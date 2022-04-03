package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class TaskGroup implements Serializable
{
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private List<Task> tasks;
    private int numRequired;

    public TaskGroup() { }

    public TaskGroup(List<Task> tasks, int numRequired)
    {
        this.tasks = tasks;
        this.numRequired = numRequired;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public List<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<Task> tasks)
    {
        this.tasks = tasks;
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
