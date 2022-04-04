package edu.ntnu.idatt2105.newqs.model.queue;

public class QueueJoinRequest
{
    private String type;
    private String tableNr;
    private int task;

    public QueueJoinRequest() { }

    public QueueJoinRequest(String type, String tableNr, int task)
    {
        this.type = type;
        this.tableNr = tableNr;
        this.task = task;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTableNr()
    {
        return tableNr;
    }

    public void setTableNr(String tableNr)
    {
        this.tableNr = tableNr;
    }

    public int getTask()
    {
        return task;
    }

    public void setTask(int task)
    {
        this.task = task;
    }
}
