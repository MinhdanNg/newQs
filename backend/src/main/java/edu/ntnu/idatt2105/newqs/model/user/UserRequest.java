package edu.ntnu.idatt2105.newqs.model.user;

public class UserRequest
{
    private long userId;

    public UserRequest() { }

    public UserRequest(long userId)
    {
        this.userId = userId;
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
