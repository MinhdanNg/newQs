package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.model.queue.*;
import edu.ntnu.idatt2105.newqs.service.QueueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/queue")
@EnableAutoConfiguration
@CrossOrigin
public class QueueController
{
    private static final Logger LOGGER = LogManager.getLogger(QueueController.class);
    @Autowired
    private QueueService queueService;

    @PutMapping(value = "/start/{queueId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void start(@PathVariable long queueId)
    {
        queueService.start(queueId);
    }

    @PutMapping(value = "/stop/{queueId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void stop(@PathVariable long queueId)
    {
        queueService.stop(queueId);
    }

    @GetMapping(value = "/get/{queueId}")
    @ResponseStatus(value = HttpStatus.OK)
    public QueueResponse get(@PathVariable long queueId)
    {
        return queueService.get(queueId);
    }

    @PostMapping(value = "/join/{queueId}")
    @ResponseStatus(value = HttpStatus.OK)
    public QueueResponse join(@PathVariable long queueId, @RequestBody QueueJoinRequest request)
    {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return queueService.join(queueId, userId, request);
    }
}
