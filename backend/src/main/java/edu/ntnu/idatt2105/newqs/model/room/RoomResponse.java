package edu.ntnu.idatt2105.newqs.model.room;

public class RoomResponse
{
    private long id;
    private String name;
    private int numTables;
    private String imageURL;

    public RoomResponse() { }

    public RoomResponse(long id, String name, int numTables, String imageURL)
    {
        this.id = id;
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
