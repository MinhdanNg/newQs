package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TaskGroup
{
    @Id
    @GeneratedValue
    private long id;
    private int numTasks;
    private int numRequired;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
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
