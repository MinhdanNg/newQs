package edu.ntnu.idatt2105.newqs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/queueitem")
@EnableAutoConfiguration
@CrossOrigin
public class QueueItemController
{
    private static final Logger LOGGER = LogManager.getLogger(QueueItemController.class);

    @PutMapping(value = "/{item_id}/assist")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void assist(@PathVariable String item_id)
    {

    }

    @DeleteMapping(value = "/{item_id}/finish")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void finish(@PathVariable String item_id)
    {

    }

    @PutMapping(value = "/{item_id}/postpone")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void postpone(@PathVariable String item_id)
    {

    }
}
