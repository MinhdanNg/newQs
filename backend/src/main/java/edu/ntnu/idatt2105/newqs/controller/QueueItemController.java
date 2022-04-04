package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.service.QueueItemService;
import edu.ntnu.idatt2105.newqs.service.AuthorizationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/subject/{subjectId}/queue-item")
@EnableAutoConfiguration
@CrossOrigin
public class QueueItemController
{
    private static final Logger LOGGER = LogManager.getLogger(QueueItemController.class);
    @Autowired
    private QueueItemService queueItemService;
    @Autowired
    private AuthorizationService authorizationService;

    @PutMapping(value = "/{studentId}/assist")
    @ResponseStatus(value = HttpStatus.OK)
    public void assist(@PathVariable long subjectId, @PathVariable String studentId) throws AccessException
    {
        authorizationService.assertAssistantGrant(subjectId);
        queueItemService.assist(subjectId, studentId, authorizationService.getUserId());
    }

    @DeleteMapping(value = "/{studentId}/approve")
    @ResponseStatus(value = HttpStatus.OK)
    public void approve(@PathVariable long subjectId, @PathVariable String studentId) throws AccessException
    {
        authorizationService.assertAssistantGrant(subjectId);
        queueItemService.approve(subjectId, studentId);
    }

    @DeleteMapping(value = "/{studentId}/reject")
    @ResponseStatus(value = HttpStatus.OK)
    public void reject(@PathVariable long subjectId, @PathVariable String studentId) throws AccessException
    {
        authorizationService.assertAssistantGrant(subjectId);
        queueItemService.reject(subjectId, studentId);
    }

    @PutMapping(value = "/{studentId}/postpone")
    @ResponseStatus(value = HttpStatus.OK)
    public void postpone(@PathVariable long subjectId, @PathVariable String studentId) throws AccessException
    {
        authorizationService.assertIsUser(subjectId, studentId);
        queueItemService.postpone(subjectId, studentId);
    }
}
