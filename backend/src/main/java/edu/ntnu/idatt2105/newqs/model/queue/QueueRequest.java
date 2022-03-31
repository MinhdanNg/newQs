package edu.ntnu.idatt2105.newqs.model.queue;

public class QueueRequest
{
    private long queueId;

    public QueueRequest() { }

    public QueueRequest(long queueId)
    {
        this.queueId = queueId;
    }

    public long getQueueId()
    {
        return queueId;
    }

    public void setQueueId(long queueId)
    {
        this.queueId = queueId;
    }
}
