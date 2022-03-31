package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@EnableAutoConfiguration
@CrossOrigin
public class HomeController {
    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
    @GetMapping(value = "")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String doLogin(){
        String message = "Say hello...";
        LOGGER.info(message);
        return message;
    }

}