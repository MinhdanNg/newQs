package edu.ntnu.idatt2105.newqs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/subject")
@EnableAutoConfiguration
@CrossOrigin
public class SubjectController
{
    private static final Logger LOGGER = LogManager.getLogger(SubjectController.class);

    @PostMapping(value = "/register")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void register()
    {

    }

    @PutMapping(value = "/{queue_id}/activate")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void activate(@PathVariable String queue_id)
    {

    }

    @PutMapping(value = "/{queue_id}/archive")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void archive(@PathVariable String queue_id)
    {

    }

    @DeleteMapping(value = "/{queue_id}/delete")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String queue_id)
    {

    }

    @PostMapping(value = "/{queue_id}/users/add")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void addUsers(@PathVariable String queue_id)
    {

    }

    @GetMapping(value = "/{queue_id}/users/get")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void getUsers(@PathVariable String queue_id)
    {

    }

    @GetMapping(value = "/{queue_id}/users/get/{user_id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void getUser(@PathVariable String queue_id, @PathVariable("user_id") String user_id)
    {

    }
}
