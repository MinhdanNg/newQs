package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.model.subject.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService
{
    private static final Logger LOGGER = LogManager.getLogger(SubjectService.class);

    public SubjectResponse register(SubjectRegisterRequest request)
    {
        return null;
    }

    public SubjectResponse get(SubjectRequest request)
    {
        return null;
    }

    public void activate(SubjectRequest request)
    {

    }

    public void archive(SubjectRequest request)
    {

    }

    public void delete(SubjectRequest request)
    {

    }

    public void addUsers(SubjectAddUsersRequest request)
    {

    }

    public SubjectGetTaskOverviewResponse getTaskOverview(SubjectGetTaskOverviewRequest request)
    {
        return null;
    }

    public List<SubjectGetTaskOverviewResponse> getAllTaskOverview(SubjectRequest request)
    {
        return null;
    }
}
