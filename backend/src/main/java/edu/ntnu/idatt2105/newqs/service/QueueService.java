package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.model.queue.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class QueueService
{
    private static final Logger LOGGER = LogManager.getLogger(QueueService.class);

    public void start(long queueId)
    {

    }

    public void stop(long queueId)
    {

    }

    public QueueResponse get(long queueId)
    {
        return null;
    }

    public QueueResponse join(long queueId, String userId, QueueJoinRequest request)
    {
        return null;
    }
}
