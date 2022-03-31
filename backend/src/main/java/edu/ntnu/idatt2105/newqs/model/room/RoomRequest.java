package edu.ntnu.idatt2105.newqs.model.room;

public class RoomRequest
{
    private long roomId;

    public RoomRequest() { }

    public RoomRequest(long roomId)
    {
        this.roomId = roomId;
    }

    public long getRoomId()
    {
        return roomId;
    }

    public void setRoomId(long roomId)
    {
        this.roomId = roomId;
    }
}
