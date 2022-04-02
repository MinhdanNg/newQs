package edu.ntnu.idatt2105.newqs.repository.tasks;

import java.util.List;

public class TasksResponse
{
    private int numTasks;
    private List<TaskGroupResponse> taskGroups;

    public TasksResponse() { }

    public TasksResponse(int numTasks, List<TaskGroupResponse> taskGroups)
    {
        this.numTasks = numTasks;
        this.taskGroups = taskGroups;
    }

    public int getNumTasks()
    {
        return numTasks;
    }

    public void setNumTasks(int numTasks)
    {
        this.numTasks = numTasks;
    }

    public List<TaskGroupResponse> getTaskGroups()
    {
        return taskGroups;
    }

    public void setTaskGroups(List<TaskGroupResponse> taskGroups)
    {
        this.taskGroups = taskGroups;
    }
}
