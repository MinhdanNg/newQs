package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.entity.*;
import edu.ntnu.idatt2105.newqs.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueueItemService
{
    private static final Logger LOGGER = LogManager.getLogger(QueueItemService.class);
    @Autowired
    private QueueService queueService;
    @Autowired
    private QueueItemRepository queueItemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private QueueRepository queueRepository;

    public void assist(long subjectId, String studentId, String assistantId)
    {
        User assistant = userRepository.findById(assistantId).orElseThrow();
        QueueItem queueItem = findQueueItem(subjectId, studentId);
        queueItem.setAssistedBy(assistant);
        queueItemRepository.save(queueItem);
    }

    public void approve(long subjectId, String studentId)
    {
        QueueItem queueItem = findQueueItem(subjectId, studentId);

        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        User student = userRepository.findById(studentId).orElseThrow();

        List<Task> approvedTasks = new ArrayList<>();

        student.getApprovedTasks().addAll(queueItem.getTasks());

        userRepository.save(student);
        queueItemRepository.delete(queueItem);
    }

    public void reject(long subjectId, String studentId)
    {
        QueueItem queueItem = findQueueItem(subjectId, studentId);
        queueItemRepository.delete(queueItem);
    }

    public void postpone(long subjectId, String studentId)
    {
        Queue queue = queueService.findQueue(subjectId);
        QueueItem queueItem = findQueueItem(subjectId, studentId);

        queue.getItems().remove(queueItem);
        queue.getItems().add(queueItem);

        queueRepository.save(queue);
    }

    public QueueItem findQueueItem(long subjectId, String studentId)
    {
        User student = userRepository.findById(studentId).orElseThrow();
        return queueService.findQueue(subjectId).getItems().stream()
                .filter(item -> item.getStudent() == student).findFirst().orElseThrow();
    }
}
