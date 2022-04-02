package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.model.user.*;
import edu.ntnu.idatt2105.newqs.service.UserService;
import org.apache.catalina.util.URLEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/user")
@EnableAutoConfiguration
@CrossOrigin
public class UserController
{
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}/get")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse get(@PathVariable String userId)
    {
        return userService.get(userId);
    }

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest request)
    {
        final String uri = "http://localhost:8080/auth/realms/master/protocol/openid-connect/token";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("bmV3UXNfY2xpZW50OjAxMTM1NjZjLWE0NzEtNGI3Zi05MTY5LTMwY2JmNzdiOTllZg==");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type","password");
        map.add("scope","openid");
        map.add("client_id","newQs_client");
        map.add("username", request.getUsername());
        map.add("password", request.getPassword());

        HttpEntity<MultiValueMap<String, String>> accessTokenRequest = new HttpEntity<>(map, headers);

        ResponseEntity<AccessTokenResponse> responseEntity = restTemplate.postForEntity(uri, accessTokenRequest, AccessTokenResponse.class);

        AccessTokenResponse accessTokenResponse = responseEntity.getBody();

        return new LoginResponse(accessTokenResponse.getAccess_token(), accessTokenResponse.getExpires_in());
    }
}
