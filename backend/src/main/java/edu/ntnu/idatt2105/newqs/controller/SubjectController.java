package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.model.subject.*;
import edu.ntnu.idatt2105.newqs.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subject")
@EnableAutoConfiguration
@CrossOrigin
public class SubjectController
{
    private static final Logger LOGGER = LogManager.getLogger(SubjectController.class);
    @Autowired
    private SubjectService subjectService;

    @PostMapping(value = "/register")
    @ResponseStatus(value = HttpStatus.OK)
    public SubjectResponse register(@RequestBody SubjectRegisterRequest request)
    {
        return subjectService.register(request);
    }

    @GetMapping(value = "/{subjectId}/get")
    @ResponseStatus(value = HttpStatus.OK)
    public SubjectResponse get(@PathVariable long subjectId)
    {
        return subjectService.get(subjectId);
    }

    @PutMapping(value = "/{subjectId}/activate")
    @ResponseStatus(value = HttpStatus.OK)
    public void activate(@PathVariable long subjectId)
    {
        subjectService.activate(subjectId);
    }

    @PutMapping(value = "/{subjectId}/archive")
    @ResponseStatus(value = HttpStatus.OK)
    public void archive(@PathVariable long subjectId)
    {
        subjectService.archive(subjectId);
    }

    @DeleteMapping(value = "/{subjectId}/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable long subjectId)
    {
        subjectService.delete(subjectId);
    }

    @PostMapping(value = "/{subjectId}/add-users")
    @ResponseStatus(value = HttpStatus.OK)
    public void addUsers(@PathVariable long subjectId, @RequestBody SubjectAddUsersRequest request)
    {
        subjectService.addUsers(subjectId, request);
    }

    @GetMapping(value = "/{subjectId}/get-my-task-overview")
    @ResponseStatus(value = HttpStatus.OK)
    public SubjectGetTaskOverviewResponse getMyTaskOverview(@PathVariable long subjectId)
    {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return subjectService.getMyTaskOverview(subjectId, userId);
    }

    @GetMapping(value = "/{subjectId}/get-all-task-overview")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SubjectGetTaskOverviewResponse> getAllTaskOverview(@PathVariable long subjectId)
    {
        return subjectService.getAllTaskOverview(subjectId);
    }
}
