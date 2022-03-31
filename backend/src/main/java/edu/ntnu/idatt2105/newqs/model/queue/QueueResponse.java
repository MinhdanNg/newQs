package edu.ntnu.idatt2105.newqs.model.queue;

import edu.ntnu.idatt2105.newqs.model.queueitem.QueueItemResponse;
import edu.ntnu.idatt2105.newqs.model.room.RoomResponse;

import java.util.List;

public class QueueResponse
{
    private long queueId;
    private boolean isActive;
    private RoomResponse room;
    private List<QueueItemResponse> items;

    public QueueResponse() { }

    public QueueResponse(long queueId, boolean isActive, RoomResponse room, List<QueueItemResponse> items)
    {
        this.queueId = queueId;
        this.isActive = isActive;
        this.room = room;
        this.items = items;
    }

    public long getQueueId()
    {
        return queueId;
    }

    public void setQueueId(long queueId)
    {
        this.queueId = queueId;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    public RoomResponse getRoom()
    {
        return room;
    }

    public void setRoom(RoomResponse room)
    {
        this.room = room;
    }

    public List<QueueItemResponse> getItems()
    {
        return items;
    }

    public void setItems(List<QueueItemResponse> items)
    {
        this.items = items;
    }
}
