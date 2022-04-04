package edu.ntnu.idatt2105.newqs.util;

import edu.ntnu.idatt2105.newqs.entity.*;
import edu.ntnu.idatt2105.newqs.model.queue.QueueResponse;
import edu.ntnu.idatt2105.newqs.model.queue.QueueItemResponse;
import edu.ntnu.idatt2105.newqs.model.subject.SubjectResponse;
import edu.ntnu.idatt2105.newqs.model.tasks.TaskGroupResponse;
import edu.ntnu.idatt2105.newqs.model.user.AccessTokenResponse;
import edu.ntnu.idatt2105.newqs.model.user.LoginResponse;
import edu.ntnu.idatt2105.newqs.model.user.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper
{
    public static SubjectResponse ToSubjectResponse(Subject subject)
    {
        int numTasks = subject.getTaskGroups().stream().mapToInt(taskGroup -> taskGroup.getTasks().size()).sum();

        return new SubjectResponse(
                subject.getId(),
                subject.getCode(),
                subject.getName(),
                subject.isActive(),
                ToUserResponses(subject.getTeachers()),
                ToUserResponses(subject.getAssistants()),
                ToUserResponses(subject.getStudents()),
                numTasks,
                ToTaskGroupResponses(subject.getTaskGroups())
        );
    }

    public static List<SubjectResponse> ToSubjectResponses(List<Subject> subjects)
    {
        return subjects.stream().map(Mapper::ToSubjectResponse).collect(Collectors.toList());
    }

    public static List<UserResponse> ToUserResponses(List<User> users)
    {
        return users.stream().map(Mapper::ToUserResponse).collect(Collectors.toList());
    }

    public static UserResponse ToUserResponse(User user)
    {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getIsTeacher()
        );
    }

    public static List<TaskGroupResponse> ToTaskGroupResponses(List<TaskGroup> taskGroups)
    {
        return taskGroups.stream().map(Mapper::ToTaskGroupResponse).collect(Collectors.toList());
    }

    public static TaskGroupResponse ToTaskGroupResponse(TaskGroup taskGroup)
    {
        return new TaskGroupResponse(
                taskGroup.getTasks().size(),
                taskGroup.getNumRequired()
        );
    }

    public static QueueResponse ToQueueResponse(Queue queue)
    {
        return new QueueResponse(
                queue.isActive(),
                ToQueueItemResponses(queue.getItems())
        );
    }

    public static List<QueueItemResponse> ToQueueItemResponses(List<QueueItem> items)
    {
        return items.stream().map(Mapper::ToQueueItemResponse).collect(Collectors.toList());
    }

    public static QueueItemResponse ToQueueItemResponse(QueueItem item)
    {
        return new QueueItemResponse(
                ToUserResponse(item.getStudent()),
                item.getTasks().stream().map(Task::getTaskNr).mapToInt(taskNr -> taskNr).toArray(),
                item.getAssistedBy() != null ? ToUserResponse(item.getAssistedBy()) : null,
                item.getType(),
                item.getTableNr()
        );
    }

    public static LoginResponse ToLoginResponse(AccessTokenResponse accessTokenResponse, User user)
    {
        return new LoginResponse(
                accessTokenResponse.getAccess_token(),
                accessTokenResponse.getExpires_in(),
                user != null ? user.getId() : null,
                user != null ? user.getFirstName() : null,
                user != null ? user.getLastName() : null,
                user != null ? user.getEmail() : null,
                user != null ? user.getEmail() : null,
                user != null ? user.getIsTeacher() : false
                );
    }
}
