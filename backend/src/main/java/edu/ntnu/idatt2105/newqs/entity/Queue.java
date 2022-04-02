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
    @ManyToOne
    private Room room;
    @OneToMany
    private List<QueueItem> items;

    public Queue()
    {
        isActive = true;
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

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room = room;
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