package edu.ntnu.idatt2105.newqs.model.subject;

public class SubjectAddUsersRequest
{
    private long subjectId;
    private String users;

    public SubjectAddUsersRequest() { }

    public SubjectAddUsersRequest(long subjectId, String users)
    {
        this.subjectId = subjectId;
        this.users = users;
    }

    public long getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(long subjectId)
    {
        this.subjectId = subjectId;
    }

    public String getUsers()
    {
        return users;
    }

    public void setUsers(String users)
    {
        this.users = users;
    }
}
