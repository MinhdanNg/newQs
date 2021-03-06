package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable
{
    @Id
    private String Id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isTeacher;
    @ManyToMany
    private List<Task> approvedTasks;

    public User() { }

    public User(String id, String firstName, String lastName, String email, boolean isTeacher)
    {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isTeacher = isTeacher;
    }

    public String getId()
    {
        return Id;
    }

    public void setId(String id)
    {
        this.Id = id;
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

    public boolean getIsTeacher()
    {
        return isTeacher;
    }

    public void setIsTeacher(boolean isTeacher)
    {
        this.isTeacher = isTeacher;
    }

    public List<Task> getApprovedTasks()
    {
        return approvedTasks;
    }

    public void setApprovedTasks(List<Task> approvedTasks)
    {
        this.approvedTasks = approvedTasks;
    }
}
