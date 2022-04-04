package edu.ntnu.idatt2105.newqs.model.user;

public class UserRegisterRequest
{
    private String firstName;
    private String lastName;
    private String email;
    private boolean isTeacher;
    private long[] studentSubjects;
    private long[] assistantSubjects;

    public UserRegisterRequest() {}

    public UserRegisterRequest(String firstName, String lastName, String email, boolean isTeacher, long[] studentSubjects, long[] assistantSubjects)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isTeacher = isTeacher;
        this.studentSubjects = studentSubjects;
        this.assistantSubjects = assistantSubjects;
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

    public long[] getStudentSubjects()
    {
        return studentSubjects;
    }

    public void setStudentSubjects(long[] studentSubjects)
    {
        this.studentSubjects = studentSubjects;
    }

    public long[] getAssistantSubjects()
    {
        return assistantSubjects;
    }

    public void setAssistantSubjects(long[] assistantSubjects)
    {
        this.assistantSubjects = assistantSubjects;
    }
}
