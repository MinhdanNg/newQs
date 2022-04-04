package edu.ntnu.idatt2105.newqs.model.queue;

import edu.ntnu.idatt2105.newqs.model.user.UserResponse;

public class QueueItemResponse
{
    private UserResponse student;
    private int task;
    private UserResponse assistedBy;
    private String type;
    private String table;

    public QueueItemResponse() { }

    public QueueItemResponse(UserResponse student, int tasks, UserResponse assistedBy, String type, String table)
    {
        this.student = student;
        this.task = task;
        this.assistedBy = assistedBy;
        this.type = type;
        this.table = table;
    }

    public UserResponse getStudent()
    {
        return student;
    }

    public void setStudent(UserResponse student)
    {
        this.student = student;
    }

    public int getTask()
    {
        return task;
    }

    public void setTasks(int task)
    {
        this.task = task;
    }

    public UserResponse getAssistedBy()
    {
        return assistedBy;
    }

    public void setAssistedBy(UserResponse assistedBy)
    {
        this.assistedBy = assistedBy;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTable()
    {
        return table;
    }

    public void setTable(String table)
    {
        this.table = table;
    }
}
