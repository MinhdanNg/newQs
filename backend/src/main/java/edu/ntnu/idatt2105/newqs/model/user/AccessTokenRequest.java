package edu.ntnu.idatt2105.newqs.model.user;

public class AccessTokenRequest
{
    String grant_type = "password";
    String scope = "openid";
    String client_id = "newQs_client";
    String username;
    String password;

    public AccessTokenRequest() { }

    public AccessTokenRequest(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getGrant_type()
    {
        return grant_type;
    }

    public void setGrant_type(String grant_type)
    {
        this.grant_type = grant_type;
    }

    public String getScope()
    {
        return scope;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }

    public String getClient_id()
    {
        return client_id;
    }

    public void setClient_id(String client_id)
    {
        this.client_id = client_id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
