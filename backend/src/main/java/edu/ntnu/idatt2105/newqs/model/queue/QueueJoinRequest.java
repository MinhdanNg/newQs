package edu.ntnu.idatt2105.newqs.model.queue;

import java.util.List;

public class QueueJoinRequest
{
    private String type;
    private String tableNr;
    private List<Integer> tasks;

    public QueueJoinRequest() { }

    public QueueJoinRequest(String type, String tableNr, List<Integer> tasks)
    {
        this.type = type;
        this.tableNr = tableNr;
        this.tasks = tasks;
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

    public List<Integer> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<Integer> tasks)
    {
        this.tasks = tasks;
    }
}
