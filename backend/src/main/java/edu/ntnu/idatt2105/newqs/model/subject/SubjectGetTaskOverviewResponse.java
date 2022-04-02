package edu.ntnu.idatt2105.newqs.model.subject;

import edu.ntnu.idatt2105.newqs.model.user.UserResponse;

public class SubjectGetTaskOverviewResponse
{
    private UserResponse student;
    private int[] approvedTasks;

    public SubjectGetTaskOverviewResponse() { }

    public SubjectGetTaskOverviewResponse(UserResponse student, int[] approvedTasks)
    {
        this.student = student;
        this.approvedTasks = approvedTasks;
    }

    public UserResponse getStudent()
    {
        return student;
    }

    public void setStudent(UserResponse student)
    {
        this.student = student;
    }

    public int[] getApprovedTasks()
    {
        return approvedTasks;
    }

    public void setApprovedTasks(int[] approvedTasks)
    {
        this.approvedTasks = approvedTasks;
    }
}
