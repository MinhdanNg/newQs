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
    @ManyToMany
    private List<Task> tasks;
    @ManyToOne
    private User assistedBy;
    private String type;
    private Date timeJoined;
    private String tableNr;

    public QueueItem() { }

    public QueueItem(User student, List<Task> tasks, User assistedBy, String type, Date timeJoined, String tableNr)
    {
        this.student = student;
        this.tasks = tasks;
        this.assistedBy = assistedBy;
        this.type = type;
        this.timeJoined = timeJoined;
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

    public List<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<Task> tasks)
    {
        this.tasks = tasks;
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

    public Date getTimeJoined()
    {
        return timeJoined;
    }

    public void setTimeJoined(Date timeJoined)
    {
        this.timeJoined = timeJoined;
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
