package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.entity.User;
import edu.ntnu.idatt2105.newqs.model.user.*;
import edu.ntnu.idatt2105.newqs.repository.UserRepository;
import edu.ntnu.idatt2105.newqs.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    private final RestTemplate restTemplate;

    public UserService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<UserResponse> getAll()
    {
        List<User> users = (List<User>) userRepository.findAll();
        return Mapper.ToUserResponses(users);
    }

    public UserResponse get(String userId)
    {
        User user = userRepository.findById(userId).orElseThrow();
        return Mapper.ToUserResponse(user);
    }

    public LoginResponse login(LoginRequest request)
    {
        final String uri = "http://localhost:8080/auth/realms/master/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("bmV3UXNfY2lsZW50OmMxOTY1ZTBkLWRjZGQtNDQ5MC04MzlhLTRlOGJmMGM1MzgwOA==");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type","password");
        map.add("scope","openid");
        map.add("client_id","newQs_client");
        map.add("username", request.getUsername());
        map.add("password", request.getPassword());

        HttpEntity<MultiValueMap<String, String>> accessTokenRequest = new HttpEntity<>(map, headers);

        ResponseEntity<AccessTokenResponse> responseEntity = restTemplate.postForEntity(uri, accessTokenRequest, AccessTokenResponse.class);

        AccessTokenResponse accessTokenResponse = responseEntity.getBody();

        Optional<User> optionalUser = userRepository.findUserByEmail(request.getUsername());

        User user;
        if (optionalUser.isEmpty())
        {
            user = getKeycloak(request.getUsername());
            if (user == null)
            {
                return null;
            }

            userRepository.save(user);
        }
        else
        {
            user = optionalUser.get();
        }

        return Mapper.ToLoginResponse(accessTokenResponse, user);
    }

    public List<User> getOrCreate(String usersCSV, boolean isTeacher)
    {
        LOGGER.trace(usersCSV);
        List<User> users = new ArrayList<>();

        String[] lines = usersCSV.split("\n");
        for (String line : lines)
        {
            String[] fields = line.split(",");
            if (fields.length != 3)
            {
                throw new IllegalArgumentException("All lines in CSV must have 3 fields in this order: last name, first name, email");
            }

            String lastName = fields[0].strip();
            String firstName = fields[1].strip();
            String email = fields[2].strip();

            LOGGER.trace("Email: " + email);

            Optional<User> optionalUser = userRepository.findUserByEmail(email);

            User user;
            if (optionalUser.isEmpty())
            {
                user = register(firstName, lastName, email, isTeacher);
            }
            else
            {
                user = optionalUser.get();
            }

            if (isTeacher)
            {
                user.setIsTeacher(true);
                userRepository.save(user);
            }

            users.add(user);
        }
        return users;
    }

    private User register(String firstName, String lastName, String email, boolean isTeacher)
    {
        User user = getKeycloak(email);

        if (user == null)
        {
            user = registerKeycloak(firstName, lastName, email, isTeacher);
        }

        userRepository.save(user);
        return user;
    }

    private User registerKeycloak(String firstName, String lastName, String email, boolean isTeacher)
    {
        String accessToken = getAdminAccessToken();

        final String uri = "http://localhost:8080/auth/admin/realms/master/users";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        JSONObject userJSONObject = new JSONObject();

        try
        {
            userJSONObject.put("firstName", firstName);
            userJSONObject.put("lastName", lastName);
            userJSONObject.put("email", email);
            userJSONObject.put("username", email);
            userJSONObject.put("enabled", true);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        LOGGER.trace(userJSONObject.toString());

        HttpEntity<String> userRegisterRequest = new HttpEntity<>(userJSONObject.toString(), headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, userRegisterRequest, String.class);

        String url = responseEntity.getHeaders().getLocation().toString();
        String[] urlSplit = url.split("/");
        String userId = urlSplit[urlSplit.length - 1];

        return new User(userId, firstName, lastName, email, isTeacher);
    }

    private User getKeycloak(String username)
    {
        String accessToken = getAdminAccessToken();

        final String uri = "http://localhost:8080/auth/admin/realms/master/users?exact=true&username=" + username;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<String> userGetRequest = new HttpEntity<>(headers);

        ResponseEntity<List> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, userGetRequest, List.class);

        if (responseEntity.hasBody())
        {
            List list = responseEntity.getBody();

            if (list.size() == 0)
            {
                return null;
            }

            LinkedHashMap linkedHashMap = (LinkedHashMap) list.get(0);

            String id = (String) linkedHashMap.get("id");
            String firstName = (String) linkedHashMap.get("firstName");
            String lastName = (String) linkedHashMap.get("lastName");

            return new User(id, firstName, lastName, username, false);
        }

        return null;
    }

    private String getAdminAccessToken()
    {
        LoginRequest request = new LoginRequest("admin", "admin");

        final String uri = "http://localhost:8080/auth/realms/master/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("bmV3UXNfY2lsZW50OmMxOTY1ZTBkLWRjZGQtNDQ5MC04MzlhLTRlOGJmMGM1MzgwOA==");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type","password");
        map.add("scope","openid");
        map.add("client_id","newQs_client");
        map.add("username", request.getUsername());
        map.add("password", request.getPassword());

        HttpEntity<MultiValueMap<String, String>> accessTokenRequest = new HttpEntity<>(map, headers);

        ResponseEntity<AccessTokenResponse> responseEntity = restTemplate.postForEntity(uri, accessTokenRequest, AccessTokenResponse.class);

        AccessTokenResponse accessTokenResponse = responseEntity.getBody();

        return accessTokenResponse.getAccess_token();
    }
}
