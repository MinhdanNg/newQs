package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class QueueItem implements Serializable
{
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User student;
    @ManyToOne
    private Task task;
    @ManyToOne
    private User assistedBy;
    private String type;
    private String tableNr;

    public QueueItem() { }

    public QueueItem(User student, Task task, User assistedBy, String type, String tableNr)
    {
        this.student = student;
        this.task = task;
        this.assistedBy = assistedBy;
        this.type = type;
        this.tableNr = tableNr;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public User getStudent()
    {
        return student;
    }

    public void setStudent(User user)
    {
        this.student = user;
    }

    public Task getTask()
    {
        return task;
    }

    public void setTask(Task task)
    {
        this.task = task;
    }

    public User getAssistedBy()
    {
        return assistedBy;
    }

    public void setAssistedBy(User assistedBy)
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

    public String getTableNr()
    {
        return tableNr;
    }

    public void setTableNr(String table)
    {
        this.tableNr = table;
    }
}
