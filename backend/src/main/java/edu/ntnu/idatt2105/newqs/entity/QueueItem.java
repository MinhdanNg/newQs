package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class QueueItem implements Serializable
{
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private User assistedBy;
    private String type;
    private Date timeJoined;
    private String tableNr;

    public QueueItem() { }

    public QueueItem(User user, User assistedBy, String type, Date timeJoined, String tableNr)
    {
        this.user = user;
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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
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
