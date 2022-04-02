package edu.ntnu.idatt2105.newqs.model.subject;

public class SubjectAddUsersRequest
{
    private String studentsCSV;
    private String assistantsCSV;
    private String teachersCSV;

    public SubjectAddUsersRequest() { }

    public SubjectAddUsersRequest(String studentsCSV, String assistantsCSV, String teachersCSV)
    {
        this.studentsCSV = studentsCSV;
        this.assistantsCSV = assistantsCSV;
        this.teachersCSV = teachersCSV;
    }

    public String getStudentsCSV()
    {
        return studentsCSV;
    }

    public void setStudentsCSV(String studentsCSV)
    {
        this.studentsCSV = studentsCSV;
    }

    public String getAssistantsCSV()
    {
        return assistantsCSV;
    }

    public void setAssistantsCSV(String assistantsCSV)
    {
        this.assistantsCSV = assistantsCSV;
    }

    public String getTeachersCSV()
    {
        return teachersCSV;
    }

    public void setTeachersCSV(String teachersCSV)
    {
        this.teachersCSV = teachersCSV;
    }
}
