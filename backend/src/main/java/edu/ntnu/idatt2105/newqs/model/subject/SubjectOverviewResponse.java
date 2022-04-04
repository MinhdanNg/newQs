package edu.ntnu.idatt2105.newqs.model.subject;

import java.util.List;

public class SubjectOverviewResponse
{
    private long subjectId;
    private String code;
    private String name;
    private boolean approved;
    private List<Boolean> tasks;

    public SubjectOverviewResponse() {}

    public SubjectOverviewResponse(long subjectId, String code, String name, boolean approved, List<Boolean> tasks)
    {
        this.subjectId = subjectId;
        this.code = code;
        this.name = name;
        this.approved = approved;
        this.tasks = tasks;
    }

    public long getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(long subjectId)
    {
        this.subjectId = subjectId;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isApproved()
    {
        return approved;
    }

    public void setApproved(boolean approved)
    {
        this.approved = approved;
    }

    public List<Boolean> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<Boolean> tasks)
    {
        this.tasks = tasks;
    }
}
