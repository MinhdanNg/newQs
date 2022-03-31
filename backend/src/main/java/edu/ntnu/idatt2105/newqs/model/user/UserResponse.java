package edu.ntnu.idatt2105.newqs.model.user;

public class UserResponse
{
    private String ID;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isTeacher;

    public UserResponse() { }

    public UserResponse(String ID, String firstName, String lastName, String email, boolean isTeacher)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isTeacher = isTeacher;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
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

    public boolean isTeacher()
    {
        return isTeacher;
    }

    public void setTeacher(boolean teacher)
    {
        isTeacher = teacher;
    }
}
