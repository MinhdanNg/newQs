package edu.ntnu.idatt2105.newqs.model.queue;

import edu.ntnu.idatt2105.newqs.model.user.UserResponse;

import java.util.Date;

public class QueueItemResponse
{
    private UserResponse student;
    private int[] tasks;
    private UserResponse assistedBy;
    private String type;
    private Date timeJoined;
    private String table;

    public QueueItemResponse() { }

    public QueueItemResponse(UserResponse student, int[] tasks, UserResponse assistedBy, String type, Date timeJoined, String table)
    {
        this.student = student;
        this.tasks = tasks;
        this.assistedBy = assistedBy;
        this.type = type;
        this.timeJoined = timeJoined;
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

    public int[] getTasks()
    {
        return tasks;
    }

    public void setTasks(int[] tasks)
    {
        this.tasks = tasks;
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

    public Date getTimeJoined()
    {
        return timeJoined;
    }

    public void setTimeJoined(Date timeJoined)
    {
        this.timeJoined = timeJoined;
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
