package edu.ntnu.idatt2105.newqs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Subject implements Serializable
{
    @Id
    @GeneratedValue
    private long id;
    private String code;
    private String name;
    private boolean isActive;
    @ManyToMany
    private List<User> teachers;
    @ManyToMany
    private List<User> assistants;
    @ManyToMany
    private List<User> students;
    @OneToMany
    private List<TaskGroup> taskGroups;
    @OneToOne
    private Queue queue;

    public Subject() { }

    public Subject(String code, String name, boolean isActive, List<User> teachers, List<User> assistants, List<User> students, List<TaskGroup> taskGroups, Queue queue)
    {
        this.code = code;
        this.name = name;
        this.isActive = isActive;
        this.teachers = teachers;
        this.assistants = assistants;
        this.students = students;
        this.taskGroups = taskGroups;
        this.queue = queue;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
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

    public List<User> getTeachers()
    {
        return teachers;
    }

    public void setTeachers(List<User> teachers)
    {
        this.teachers = teachers;
    }

    public List<User> getAssistants()
    {
        return assistants;
    }

    public void setAssistants(List<User> assistants)
    {
        this.assistants = assistants;
    }

    public List<User> getStudents()
    {
        return students;
    }

    public void setStudents(List<User> students)
    {
        this.students = students;
    }

    public List<TaskGroup> getTaskGroups()
    {
        return taskGroups;
    }

    public void setTaskGroups(List<TaskGroup> tasks)
    {
        this.taskGroups = tasks;
    }

    public Queue getQueue()
    {
        return queue;
    }

    public void setQueue(Queue queue)
    {
        this.queue = queue;
    }
}
