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
}
