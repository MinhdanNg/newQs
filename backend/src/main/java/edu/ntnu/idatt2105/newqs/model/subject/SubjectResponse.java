package edu.ntnu.idatt2105.newqs.model.subject;

import edu.ntnu.idatt2105.newqs.repository.tasks.TasksResponse;
import edu.ntnu.idatt2105.newqs.model.user.UserResponse;

import java.util.List;

public class SubjectResponse
{
    private long subjectId;
    private String code;
    private String name;
    private boolean isActive;
    private List<UserResponse> teachers;
    private List<UserResponse> assistants;
    private List<UserResponse> students;
    private TasksResponse tasks;
    private long queueId;

    public SubjectResponse() { }

    public SubjectResponse(long subjectId, String code, String name, boolean isActive, List<UserResponse> teachers, List<UserResponse> assistants, List<UserResponse> students, TasksResponse tasks, long queueId)
    {
        this.subjectId = subjectId;
        this.code = code;
        this.name = name;
        this.isActive = isActive;
        this.teachers = teachers;
        this.assistants = assistants;
        this.students = students;
        this.tasks = tasks;
        this.queueId = queueId;
    }

    public long getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(long subjectId)
    {
        this.subjectId = subjectId;
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

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    public List<UserResponse> getTeachers()
    {
        return teachers;
    }

    public void setTeachers(List<UserResponse> teachers)
    {
        this.teachers = teachers;
    }

    public List<UserResponse> getAssistants()
    {
        return assistants;
    }

    public void setAssistants(List<UserResponse> assistants)
    {
        this.assistants = assistants;
    }

    public List<UserResponse> getStudents()
    {
        return students;
    }

    public void setStudents(List<UserResponse> students)
    {
        this.students = students;
    }

    public TasksResponse getTasks()
    {
        return tasks;
    }

    public void setTasks(TasksResponse tasks)
    {
        this.tasks = tasks;
    }

    public long getQueueId()
    {
        return queueId;
    }

    public void setQueueId(long queueId)
    {
        this.queueId = queueId;
    }
}
