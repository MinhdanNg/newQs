package edu.ntnu.idatt2105.newqs.model.subject;

import edu.ntnu.idatt2105.newqs.model.tasks.TaskGroupRegisterRequest;
import java.util.List;

public class SubjectRegisterRequest
{
    private String code;
    private String name;
    private String teachersCSV;
    private String assistantsCSV;
    private String studentsCSV;
    private List<TaskGroupRegisterRequest> taskGroups;

    public SubjectRegisterRequest() { }

    public SubjectRegisterRequest(String code, String name, String teachersCSV, String assistantsCSV, String studentsCSV, List<TaskGroupRegisterRequest> taskGroups)
    {
        this.code = code;
        this.name = name;
        this.teachersCSV = teachersCSV;
        this.assistantsCSV = assistantsCSV;
        this.studentsCSV = studentsCSV;
        this.taskGroups = taskGroups;
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

    public String getTeachersCSV()
    {
        return teachersCSV;
    }

    public void setTeachersCSV(String teachersCSV)
    {
        this.teachersCSV = teachersCSV;
    }

    public String getAssistantsCSV()
    {
        return assistantsCSV;
    }

    public void setAssistantsCSV(String assistantsCSV)
    {
        this.assistantsCSV = assistantsCSV;
    }

    public String getStudentsCSV()
    {
        return studentsCSV;
    }

    public void setStudentsCSV(String studentsCSV)
    {
        this.studentsCSV = studentsCSV;
    }

    public List<TaskGroupRegisterRequest> getTaskGroups()
    {
        return taskGroups;
    }

    public void setTaskGroups(List<TaskGroupRegisterRequest> taskGroups)
    {
        this.taskGroups = taskGroups;
    }
}
