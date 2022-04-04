package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.model.user.*;
import edu.ntnu.idatt2105.newqs.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@EnableAutoConfiguration
@CrossOrigin
public class UserController
{
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get-all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserResponse> getAll()
    {
        return userService.getAll();
    }

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
        return userService.login(request);
    }
}
