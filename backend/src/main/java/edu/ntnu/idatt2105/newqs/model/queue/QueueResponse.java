package edu.ntnu.idatt2105.newqs.model.queue;

import java.util.List;

public class QueueResponse
{
    private boolean isActive;
    private List<QueueItemResponse> items;

    public QueueResponse() { }

    public QueueResponse(boolean isActive, List<QueueItemResponse> items)
    {
        this.isActive = isActive;
        this.items = items;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
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
