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

    @PutMapping(value = "/assist/{queueItemId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void assist(@PathVariable long queueItemId)
    {
        String assistantId = SecurityContextHolder.getContext().getAuthentication().getName();
        queueItemService.assist(queueItemId, assistantId);
    }

    @DeleteMapping(value = "/approve/{queueItemId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void approve(@PathVariable long queueItemId)
    {
        queueItemService.approve(queueItemId);
    }

    @DeleteMapping(value = "/reject/{queueItemId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void reject(@PathVariable long queueItemId)
    {
        queueItemService.reject(queueItemId);
    }

    @PutMapping(value = "/postpone/{queueItemId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void postpone(@PathVariable long queueItemId)
    {
        queueItemService.postpone(queueItemId);
    }
}
