package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ApprovedTask
{
    @Id
    @GeneratedValue
    private long Id;
    @ManyToOne
    private Task task;
    @ManyToOne
    private User student;

    public ApprovedTask()
    {
    }

    public ApprovedTask(Task task, User student)
    {
        this.task = task;
        this.student = student;
    }

    public long getId()
    {
        return Id;
    }

    public void setId(long id)
    {
        Id = id;
    }

    public Task getTask()
    {
        return task;
    }

    public void setTask(Task task)
    {
        this.task = task;
    }

    public User getStudent()
    {
        return student;
    }

    public void setStudent(User student)
    {
        this.student = student;
    }
}
