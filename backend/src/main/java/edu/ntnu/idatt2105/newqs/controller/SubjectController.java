package edu.ntnu.idatt2105.newqs.controller;

import edu.ntnu.idatt2105.newqs.model.subject.*;
import edu.ntnu.idatt2105.newqs.service.SubjectService;
import edu.ntnu.idatt2105.newqs.service.AuthorizationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.expression.AccessException;
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
    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping(value = "/register")
    @ResponseStatus(value = HttpStatus.OK)
    public SubjectResponse register(@RequestBody SubjectRegisterRequest request) throws AccessException
    {
        authorizationService.assertTeacherGrant();
        return subjectService.register(request);
    }

    @GetMapping(value = "/{subjectId}/get")
    @ResponseStatus(value = HttpStatus.OK)
    public SubjectResponse get(@PathVariable long subjectId) throws AccessException
    {
        authorizationService.assertStudentGrant(subjectId);
        return subjectService.get(subjectId);
    }

    @GetMapping(value = "/get-all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SubjectResponse> getAll() throws AccessException
    {
        authorizationService.assertTeacherGrant();
        return subjectService.getAll();
    }

    @GetMapping(value = "/get-where-student/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SubjectResponse> getWhereStudentFor(@PathVariable String userId) throws AccessException
    {
        authorizationService.assertIsUser(userId);
        return subjectService.getWhereStudent(userId);
    }

    @GetMapping(value = "/get-where-student")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SubjectResponse> getWhereStudent()
    {
        return subjectService.getWhereStudent(authorizationService.getUserId());
    }

    @GetMapping(value = "/get-where-assistant")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SubjectResponse> getWhereAssistant()
    {
        return subjectService.getWhereAssistant(authorizationService.getUserId());
    }

    @PutMapping(value = "/{subjectId}/activate")
    @ResponseStatus(value = HttpStatus.OK)
    public void activate(@PathVariable long subjectId) throws AccessException
    {
        authorizationService.assertTeacherGrant();
        subjectService.activate(subjectId);
    }

    @PutMapping(value = "/{subjectId}/archive")
    @ResponseStatus(value = HttpStatus.OK)
    public void archive(@PathVariable long subjectId) throws AccessException
    {
        authorizationService.assertTeacherGrant();
        subjectService.archive(subjectId);
    }

    @DeleteMapping(value = "/{subjectId}/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable long subjectId) throws AccessException
    {
        authorizationService.assertTeacherGrant();
        subjectService.delete(subjectId);
    }

    @PostMapping(value = "/{subjectId}/add-users")
    @ResponseStatus(value = HttpStatus.OK)
    public void addUsers(@PathVariable long subjectId, @RequestBody SubjectAddUsersRequest request) throws AccessException
    {
        authorizationService.assertAssistantGrant(subjectId);
        subjectService.addUsers(subjectId, request);
    }

    @GetMapping(value = "/get-subject-overview/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public StudentSubjectOverviewResponse getSubjectOverviewFor(@PathVariable String userId) throws AccessException
    {
        authorizationService.assertIsUser(userId);
        return subjectService.getSubjectOverview(userId);
    }

    @GetMapping(value = "/get-my-subject-overview")
    @ResponseStatus(value = HttpStatus.OK)
    public StudentSubjectOverviewResponse getMySubjectOverview()
    {
        return subjectService.getSubjectOverview(authorizationService.getUserId());
    }
}
