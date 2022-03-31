package edu.ntnu.idatt2105.newqs.model.subject;

public class SubjectGetTaskOverviewRequest
{
    private long subjectId;
    private long userId;

    public SubjectGetTaskOverviewRequest() { }

    public SubjectGetTaskOverviewRequest(long subjectId, long userId)
    {
        this.subjectId = subjectId;
        this.userId = userId;
    }

    public long getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(long subjectId)
    {
        this.subjectId = subjectId;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }
}
