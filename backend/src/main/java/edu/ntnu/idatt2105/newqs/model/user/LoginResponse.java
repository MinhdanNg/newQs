package edu.ntnu.idatt2105.newqs.model.user;

public class LoginResponse
{
    String accessToken;
    int expiresIn;
    String firstName;
    String lastName;
    String email;
    String username;
    boolean isTeacher;

    public LoginResponse() { }

    public LoginResponse(String accessToken, int expiresIn, String firstName, String lastName, String email, String username, boolean isTeacher)
    {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.isTeacher = isTeacher;
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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public boolean isTeacher()
    {
        return isTeacher;
    }

    public void setTeacher(boolean teacher)
    {
        isTeacher = teacher;
    }
}
