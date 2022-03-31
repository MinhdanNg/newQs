package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.model.queueitem.*;
import edu.ntnu.idatt2105.newqs.service.QueueItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private QueueItemService queueItemService;

    @PutMapping(value = "/assist")
    @ResponseStatus(value = HttpStatus.OK)
    public void assist(@RequestBody QueueItemAssistRequest request)
    {
        queueItemService.assist(request);
    }

    @DeleteMapping(value = "/approve")
    @ResponseStatus(value = HttpStatus.OK)
    public void approve(@RequestBody QueueItemRequest request)
    {
        queueItemService.approve(request);
    }

    @DeleteMapping(value = "/reject")
    @ResponseStatus(value = HttpStatus.OK)
    public void reject(@RequestBody QueueItemRequest request)
    {
        queueItemService.reject(request);
    }

    @PutMapping(value = "/postpone")
    @ResponseStatus(value = HttpStatus.OK)
    public void postpone(@RequestBody QueueItemRequest request)
    {
        queueItemService.postpone(request);
    }
}
