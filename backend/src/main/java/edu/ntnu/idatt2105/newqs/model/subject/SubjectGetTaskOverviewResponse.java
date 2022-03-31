package edu.ntnu.idatt2105.newqs.model.subject;

import edu.ntnu.idatt2105.newqs.model.user.UserResponse;

public class SubjectGetTaskOverviewResponse
{
    private UserResponse user;
    private int[] approvedTasks;

    public SubjectGetTaskOverviewResponse() { }

    public SubjectGetTaskOverviewResponse(UserResponse user, int[] approvedTasks)
    {
        this.user = user;
        this.approvedTasks = approvedTasks;
    }

    public UserResponse getUser()
    {
        return user;
    }

    public void setUser(UserResponse user)
    {
        this.user = user;
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
