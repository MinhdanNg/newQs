package edu.ntnu.idatt2105.newqs.model.subject;

public class SubjectAddUsersRequest
{
    private String users;

    public SubjectAddUsersRequest() { }

    public SubjectAddUsersRequest(String users)
    {
        this.users = users;
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
