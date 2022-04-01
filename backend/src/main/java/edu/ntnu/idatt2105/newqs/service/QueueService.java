package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.model.queue.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class QueueService
{
    private static final Logger LOGGER = LogManager.getLogger(QueueService.class);

    public void start(QueueRequest request)
    {

    }

    public void stop(QueueRequest request)
    {

    }

    public QueueResponse get(QueueRequest request)
    {
        return null;
    }

    public QueueResponse join(QueueJoinRequest request)
    {
        return null;
    }
}
