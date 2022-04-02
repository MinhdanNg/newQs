package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.entity.User;
import edu.ntnu.idatt2105.newqs.model.user.*;
import edu.ntnu.idatt2105.newqs.repository.UserRepository;
import edu.ntnu.idatt2105.newqs.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService
{
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public UserResponse get(String userId)
    {
        User user = userRepository.findById(userId).orElseThrow();
        return Mapper.ToUserResponse(user);
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

            User user = userRepository.findUserByEmail(email);

            if (user == null)
            {
                user = register(firstName, lastName, email, isTeacher);
            }
            else if (isTeacher)
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
        User user = new User(UUID.randomUUID().toString(), firstName, lastName, email, isTeacher);
        userRepository.save(user);
        return user;
    }
}
