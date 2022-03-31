package edu.ntnu.idatt2105.newqs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
@EnableAutoConfiguration
@CrossOrigin
public class HelloIDController
{
    private static final Logger LOGGER = LogManager.getLogger(HelloIDController.class);

    @GetMapping(value = "")
    @ResponseStatus(value = HttpStatus.OK)
    public String hello()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ID = auth.getName();

        String message = "Hello " + ID;
        LOGGER.info(message);

        return message;
    }
}
