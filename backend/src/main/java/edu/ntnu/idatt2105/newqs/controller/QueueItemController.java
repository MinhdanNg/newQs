package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.service.QueueItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @PutMapping(value = "/{studentId}/assist")
    @ResponseStatus(value = HttpStatus.OK)
    public void assist(@PathVariable long subjectId, @PathVariable String studentId)
    {
        String assistantId = SecurityContextHolder.getContext().getAuthentication().getName();
        queueItemService.assist(subjectId, studentId, assistantId);
    }

    @DeleteMapping(value = "/{studentId}/approve")
    @ResponseStatus(value = HttpStatus.OK)
    public void approve(@PathVariable long subjectId, @PathVariable String studentId)
    {
        queueItemService.approve(subjectId, studentId);
    }

    @DeleteMapping(value = "/{studentId}/reject")
    @ResponseStatus(value = HttpStatus.OK)
    public void reject(@PathVariable long subjectId, @PathVariable String studentId)
    {
        queueItemService.reject(subjectId, studentId);
    }

    @PutMapping(value = "/{studentId}/postpone")
    @ResponseStatus(value = HttpStatus.OK)
    public void postpone(@PathVariable long subjectId, @PathVariable String studentId)
    {
        queueItemService.postpone(subjectId, studentId);
    }
}
