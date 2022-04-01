package edu.ntnu.idatt2105.newqs.util;

import edu.ntnu.idatt2105.newqs.entity.*;
import edu.ntnu.idatt2105.newqs.model.queue.QueueResponse;
import edu.ntnu.idatt2105.newqs.model.queueitem.QueueItemResponse;
import edu.ntnu.idatt2105.newqs.model.room.RoomResponse;
import edu.ntnu.idatt2105.newqs.model.subject.SubjectResponse;
import edu.ntnu.idatt2105.newqs.model.tasks.TaskGroupResponse;
import edu.ntnu.idatt2105.newqs.model.tasks.TasksResponse;
import edu.ntnu.idatt2105.newqs.model.user.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper
{
    public static SubjectResponse ToSubjectResponse(Subject subject)
    {
        return new SubjectResponse(
                subject.getId(),
                subject.getCode(),
                subject.getName(),
                subject.isActive(),
                ToUserResponses(subject.getTeachers()),
                ToUserResponses(subject.getAssistants()),
                ToUserResponses(subject.getStudents()),
                ToTasksResponse(subject.getTasks()),
                subject.getQueue().getId()
        );
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

    public static TasksResponse ToTasksResponse(List<TaskGroup> tasks)
    {
        int numTasks = tasks.stream().mapToInt(TaskGroup::getNumTasks).sum();

        return new TasksResponse(
                numTasks,
                ToTaskGroupResponses(tasks)
        );
    }

    public static List<TaskGroupResponse> ToTaskGroupResponses(List<TaskGroup> taskGroups)
    {
        return taskGroups.stream().map(Mapper::ToTaskGroupResponse).collect(Collectors.toList());
    }

    public static TaskGroupResponse ToTaskGroupResponse(TaskGroup taskGroup)
    {
        return new TaskGroupResponse(
                taskGroup.getNumTasks(),
                taskGroup.getNumRequired()
        );
    }

    public static QueueResponse ToQueueResponse(Queue queue)
    {
        return new QueueResponse(
                queue.getId(),
                queue.isActive(),
                ToRoomResponse(queue.getRoom()),
                ToQueueItemResponses(queue.getItems())
        );
    }

    public static RoomResponse ToRoomResponse(Room room)
    {
        return new RoomResponse(
                room.getId(),
                room.getName(),
                room.getNumTables(),
                room.getImageURL()
        );
    }

    public static List<QueueItemResponse> ToQueueItemResponses(List<QueueItem> items)
    {
        return items.stream().map(Mapper::ToQueueItemResponse).collect(Collectors.toList());
    }

    public static QueueItemResponse ToQueueItemResponse(QueueItem item)
    {
        return new QueueItemResponse(
                item.getId(),
                ToUserResponse(item.getUser()),
                ToUserResponse(item.getAssistedBy()),
                item.getType(),
                item.getTimeJoined(),
                item.getTableNr()
        );
    }
}
