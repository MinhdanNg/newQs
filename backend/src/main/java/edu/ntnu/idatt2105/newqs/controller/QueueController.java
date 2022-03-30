package edu.ntnu.idatt2105.newqs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/queue")
@EnableAutoConfiguration
@CrossOrigin
public class QueueController
{
    private static final Logger LOGGER = LogManager.getLogger(QueueController.class);

    @PutMapping(value = "/{queue_id}/start")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void start(@PathVariable String queue_id)
    {

    }

    @PutMapping(value = "/{queue_id}/stop")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void stop(@PathVariable String queue_id)
    {

    }

    @GetMapping(value = "/{queue_id}/get")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void get(@PathVariable String queue_id)
    {

    }

    @PostMapping(value = "/{queue_id}/join")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void join(@PathVariable String queue_id)
    {

    }
}
