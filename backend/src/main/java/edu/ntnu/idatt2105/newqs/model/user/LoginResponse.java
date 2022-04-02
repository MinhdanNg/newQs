package edu.ntnu.idatt2105.newqs.model.user;

public class LoginResponse
{
    String accessToken;
    int expiresIn;

    public LoginResponse() { }

    public LoginResponse(String accessToken, int expiresIn)
    {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public int getExpiresIn()
    {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn)
    {
        this.expiresIn = expiresIn;
    }
}
