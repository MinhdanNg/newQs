package edu.ntnu.idatt2105.newqs.model.queue;

public class QueueJoinRequest
{
    private String type;
    private String tableNr;

    public QueueJoinRequest() { }

    public QueueJoinRequest(String type, String tableNr)
    {
        this.type = type;
        this.tableNr = tableNr;
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
}
