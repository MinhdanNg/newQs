package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.entity.*;
import edu.ntnu.idatt2105.newqs.model.queue.*;
import edu.ntnu.idatt2105.newqs.model.queue.QueueItemResponse;
import edu.ntnu.idatt2105.newqs.repository.*;
import edu.ntnu.idatt2105.newqs.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueueService
{
    private static final Logger LOGGER = LogManager.getLogger(QueueService.class);
    @Autowired
    private QueueRepository queueRepository;
    @Autowired
    private QueueItemRepository queueItemRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    public void start(long subjectId)
    {
        Queue queue = findQueue(subjectId);
        queue.setActive(true);
        queueRepository.save(queue);
    }

    public void stop(long subjectId)
    {
        Queue queue = findQueue(subjectId);
        queue.setActive(false);
        queueRepository.save(queue);
    }

    public QueueResponse get(long subjectId)
    {
        Queue queue = findQueue(subjectId);
        return Mapper.ToQueueResponse(queue);
    }

    public QueueItemResponse join(long subjectId, String studentId, QueueJoinRequest request)
    {
        Queue queue = findQueue(subjectId);
        User student = userRepository.findById(studentId).orElseThrow();

        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        List<TaskGroup> taskGroups = subject.getTaskGroups();
        List<Task> subjectTasks = new ArrayList<>();
        for (TaskGroup taskGroup : taskGroups)
        {
            subjectTasks.addAll(taskGroup.getTasks());
        }

        Task tasks = subjectTasks.stream().filter(task -> task.getTaskNr() == request.getTask()).findFirst().orElseThrow();

        QueueItem queueItem = new QueueItem(student, tasks, null, request.getType(), request.getTableNr());

        queueItem = queueItemRepository.save(queueItem);
        queue.getItems().add(queueItem);
        queueRepository.save(queue);

        return Mapper.ToQueueItemResponse(queueItem);
    }

    public Queue findQueue(long subjectId)
    {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        return subject.getQueue();
    }
}
