package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.repository.QueueItemRepository;
import edu.ntnu.idatt2105.newqs.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueItemService
{
    private static final Logger LOGGER = LogManager.getLogger(QueueItemService.class);
    @Autowired
    private QueueItemRepository queueItemRepository;
    @Autowired
    private UserRepository userRepository;

    public void assist(long subjectId, String studentId, String assistantId)
    {

    }

    public void approve(long subjectId, String studentId)
    {

    }

    public void reject(long subjectId, String studentId)
    {

    }

    public void postpone(long subjectId, String studentId)
    {

    }
}
