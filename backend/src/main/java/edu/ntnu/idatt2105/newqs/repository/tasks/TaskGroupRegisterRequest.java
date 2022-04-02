package edu.ntnu.idatt2105.newqs.repository.tasks;

public class TaskGroupRegisterRequest
{
    private int numTasks;
    private int numRequired;

    public TaskGroupRegisterRequest() { }

    public TaskGroupRegisterRequest(int numTasks, int numRequired)
    {
        this.numTasks = numTasks;
        this.numRequired = numRequired;
    }

    public int getNumTasks()
    {
        return numTasks;
    }

    public void setNumTasks(int numTasks)
    {
        this.numTasks = numTasks;
    }

    public int getNumRequired()
    {
        return numRequired;
    }

    public void setNumRequired(int numRequired)
    {
        this.numRequired = numRequired;
    }
}
