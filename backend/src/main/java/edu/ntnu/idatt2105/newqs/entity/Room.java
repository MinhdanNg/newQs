package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Room implements Serializable
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int numTables;
    private String imageURL;

    public Room() { }

    public Room(String name, int numTables, String imageURL)
    {
        this.name = name;
        this.numTables = numTables;
        this.imageURL = imageURL;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumTables()
    {
        return numTables;
    }

    public void setNumTables(int numTables)
    {
        this.numTables = numTables;
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }
}
