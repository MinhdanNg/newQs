package edu.ntnu.idatt2105.newqs.model.subject;

import edu.ntnu.idatt2105.newqs.model.user.UserResponse;

import java.util.List;

public class StudentSubjectOverviewResponse
{
    private UserResponse student;
    private List<SubjectOverviewResponse> subjects;

    public StudentSubjectOverviewResponse() { }

    public StudentSubjectOverviewResponse(UserResponse student, List<SubjectOverviewResponse> subjects)
    {
        this.student = student;
        this.subjects = subjects;
    }

    public UserResponse getStudent()
    {
        return student;
    }

    public void setStudent(UserResponse student)
    {
        this.student = student;
    }

    public List<SubjectOverviewResponse> getSubjects()
    {
        return subjects;
    }

    public void setSubjects(List<SubjectOverviewResponse> subjects)
    {
        this.subjects = subjects;
    }
}
