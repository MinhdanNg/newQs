package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.model.queue.*;
import edu.ntnu.idatt2105.newqs.model.queueitem.QueueItemResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class QueueService
{
    private static final Logger LOGGER = LogManager.getLogger(QueueService.class);

    public void start(long subjectId)
    {

    }

    public void stop(long subjectId)
    {

    }

    public QueueResponse get(long subjectId)
    {
        return null;
    }

    public QueueItemResponse join(long subjectId, String userId, QueueJoinRequest request)
    {
        return null;
    }
}
