package edu.ntnu.idatt2105.newqs.model.subject;

import edu.ntnu.idatt2105.newqs.model.queue.QueueResponse;
import edu.ntnu.idatt2105.newqs.model.tasks.TasksResponse;
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
    private QueueResponse queue;
}
