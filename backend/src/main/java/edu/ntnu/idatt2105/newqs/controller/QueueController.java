package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.model.queue.*;
import edu.ntnu.idatt2105.newqs.service.QueueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
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

    @PutMapping(value = "/start")
    @ResponseStatus(value = HttpStatus.OK)
    public void start(@RequestBody QueueRequest request)
    {
        queueService.start(request);
    }

    @PutMapping(value = "/stop")
    @ResponseStatus(value = HttpStatus.OK)
    public void stop(@RequestBody QueueRequest request)
    {
        queueService.stop(request);
    }

    @GetMapping(value = "/get")
    @ResponseStatus(value = HttpStatus.OK)
    public QueueResponse get(@RequestBody QueueRequest request)
    {
        return queueService.get(request);
    }

    @PostMapping(value = "/join")
    @ResponseStatus(value = HttpStatus.OK)
    public QueueResponse join(@RequestBody QueueJoinRequest request)
    {
        return queueService.join(request);
    }
}
