package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Queue implements Serializable
{
    @Id
    @GeneratedValue
    private long id;
    private boolean isActive;
    @OneToMany
    @OrderColumn
    private List<QueueItem> items;

    public Queue()
    {
        isActive = false;
        items = new ArrayList<>();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    public List<QueueItem> getItems()
    {
        return items;
    }

    public void setItems(List<QueueItem> items)
    {
        this.items = items;
    }
}
