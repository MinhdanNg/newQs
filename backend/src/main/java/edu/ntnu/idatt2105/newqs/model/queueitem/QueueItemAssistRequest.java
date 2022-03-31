package edu.ntnu.idatt2105.newqs.model.queueitem;

public class QueueItemAssistRequest
{
    private long queueItemId;
    private long assistantId;

    public QueueItemAssistRequest() { }

    public QueueItemAssistRequest(long queueItemId, long assistantId)
    {
        this.queueItemId = queueItemId;
        this.assistantId = assistantId;
    }

    public long getQueueItemId()
    {
        return queueItemId;
    }

    public void setQueueItemId(long queueItemId)
    {
        this.queueItemId = queueItemId;
    }

    public long getAssistantId()
    {
        return assistantId;
    }

    public void setAssistantId(long assistantId)
    {
        this.assistantId = assistantId;
    }
}
