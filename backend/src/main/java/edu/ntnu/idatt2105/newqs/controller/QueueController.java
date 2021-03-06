package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.model.queue.*;
import edu.ntnu.idatt2105.newqs.model.queue.QueueItemResponse;
import edu.ntnu.idatt2105.newqs.service.QueueService;
import edu.ntnu.idatt2105.newqs.service.AuthorizationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/subject/{subjectId}/queue")
@EnableAutoConfiguration
@CrossOrigin
public class QueueController
{
    private static final Logger LOGGER = LogManager.getLogger(QueueController.class);
    @Autowired
    private QueueService queueService;
    @Autowired
    private AuthorizationService authorizationService;

    @PutMapping(value = "/start")
    @ResponseStatus(value = HttpStatus.OK)
    public void start(@PathVariable long subjectId) throws AccessException
    {
        authorizationService.assertAssistantGrant(subjectId);
        queueService.start(subjectId);
    }

    @PutMapping(value = "/stop")
    @ResponseStatus(value = HttpStatus.OK)
    public void stop(@PathVariable long subjectId) throws AccessException
    {
        authorizationService.assertAssistantGrant(subjectId);
        queueService.stop(subjectId);
    }

    @GetMapping(value = "/get")
    @ResponseStatus(value = HttpStatus.OK)
    public QueueResponse get(@PathVariable long subjectId) throws AccessException
    {
        authorizationService.assertStudentGrant(subjectId);
        return queueService.get(subjectId);
    }

    @PostMapping(value = "/join")
    @ResponseStatus(value = HttpStatus.OK)
    public QueueItemResponse join(@PathVariable long subjectId, @RequestBody QueueJoinRequest request) throws AccessException
    {
        authorizationService.assertStudentGrant(subjectId);
        return queueService.join(subjectId, authorizationService.getUserId(), request);
    }
}
