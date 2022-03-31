package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int numTables;
    private String imageURL;

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
