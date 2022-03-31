package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.model.subject.*;
import edu.ntnu.idatt2105.newqs.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
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

    @GetMapping(value = "/get")
    @ResponseStatus(value = HttpStatus.OK)
    public SubjectResponse get(@RequestBody SubjectRequest request)
    {
        return subjectService.get(request);
    }

    @PutMapping(value = "/activate")
    @ResponseStatus(value = HttpStatus.OK)
    public void activate(@RequestBody SubjectRequest request)
    {
        subjectService.activate(request);
    }

    @PutMapping(value = "/archive")
    @ResponseStatus(value = HttpStatus.OK)
    public void archive(@RequestBody SubjectRequest request)
    {
        subjectService.archive(request);
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestBody SubjectRequest request)
    {
        subjectService.delete(request);
    }

    @PostMapping(value = "/add-users")
    @ResponseStatus(value = HttpStatus.OK)
    public void addUsers(@RequestBody SubjectAddUsersRequest request)
    {
        subjectService.addUsers(request);
    }

    @GetMapping(value = "/get-task-overview")
    @ResponseStatus(value = HttpStatus.OK)
    public SubjectGetTaskOverviewResponse getTaskOverview(@RequestBody SubjectGetTaskOverviewRequest request)
    {
        return subjectService.getTaskOverview(request);
    }

    @GetMapping(value = "/get-all-task-overview")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SubjectGetTaskOverviewResponse> getAllTaskOverview(@RequestBody SubjectRequest request)
    {
        return subjectService.getAllTaskOverview(request);
    }
}
