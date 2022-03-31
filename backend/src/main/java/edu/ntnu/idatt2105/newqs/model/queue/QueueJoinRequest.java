package edu.ntnu.idatt2105.newqs.model.queue;

public class QueueJoinRequest
{
    private long queueId;
    private long userId;
    private String type;
    private String table;

    public QueueJoinRequest() { }

    public QueueJoinRequest(long queueId, long userId, String type, String table)
    {
        this.queueId = queueId;
        this.userId = userId;
        this.type = type;
        this.table = table;
    }

    public long getQueueId()
    {
        return queueId;
    }

    public void setQueueId(long queueId)
    {
        this.queueId = queueId;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTable()
    {
        return table;
    }

    public void setTable(String table)
    {
        this.table = table;
    }
}
