package edu.ntnu.idatt2105.newqs.model.subject;

import edu.ntnu.idatt2105.newqs.model.tasks.TaskGroupRequest;
import java.util.List;

public class SubjectRegisterRequest
{
    private String code;
    private String name;
    private String teachers;
    private String assistants;
    private String students;
    private List<TaskGroupRequest> tasks;

    public SubjectRegisterRequest() { }

    public SubjectRegisterRequest(String code, String name, String teachers, String assistants, String students, List<TaskGroupRequest> tasks)
    {
        this.code = code;
        this.name = name;
        this.teachers = teachers;
        this.assistants = assistants;
        this.students = students;
        this.tasks = tasks;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTeachers()
    {
        return teachers;
    }

    public void setTeachers(String teachers)
    {
        this.teachers = teachers;
    }

    public String getAssistants()
    {
        return assistants;
    }

    public void setAssistants(String assistants)
    {
        this.assistants = assistants;
    }

    public String getStudents()
    {
        return students;
    }

    public void setStudents(String students)
    {
        this.students = students;
    }

    public List<TaskGroupRequest> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<TaskGroupRequest> tasks)
    {
        this.tasks = tasks;
    }
}
