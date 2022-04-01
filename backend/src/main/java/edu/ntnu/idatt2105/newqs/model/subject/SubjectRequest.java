package edu.ntnu.idatt2105.newqs.model.subject;

public class SubjectRequest
{
    private long subjectId;

    public SubjectRequest() { }

    public SubjectRequest(long subjectId)
    {
        this.subjectId = subjectId;
    }

    public long getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(long subjectId)
    {
        this.subjectId = subjectId;
    }
}
