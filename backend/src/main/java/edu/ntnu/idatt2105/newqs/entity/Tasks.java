package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Tasks
{
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private List<TaskGroup> taskGroups;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public List<TaskGroup> getTaskGroups()
    {
        return taskGroups;
    }

    public void setTaskGroups(List<TaskGroup> taskGroups)
    {
        this.taskGroups = taskGroups;
    }
}
