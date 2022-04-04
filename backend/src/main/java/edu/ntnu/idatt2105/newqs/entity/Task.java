package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task
{
    @Id
    @GeneratedValue
    private long Id;
    private int taskNr;

    public Task() { }

    public Task(int taskNr)
    {
        this.taskNr = taskNr;
    }

    public long getId()
    {
        return Id;
    }

    public void setId(long id)
    {
        Id = id;
    }

    public int getTaskNr()
    {
        return taskNr;
    }

    public void setTaskNr(int taskNr)
    {
        this.taskNr = taskNr;
    }
}
