package edu.ntnu.idatt2105.newqs.model.queueitem;

public class QueueItemRequest
{
    private long queueItemId;

    public QueueItemRequest() { }

    public QueueItemRequest(long queueItemId)
    {
        this.queueItemId = queueItemId;
    }

    public long getQueueItemId()
    {
        return queueItemId;
    }

    public void setQueueItemId(long queueItemId)
    {
        this.queueItemId = queueItemId;
    }
}
