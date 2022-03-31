package edu.ntnu.idatt2105.newqs.model.queueitem;

import edu.ntnu.idatt2105.newqs.model.user.UserResponse;

import java.util.Date;

public class QueueItemResponse
{
    private long queueItemId;
    private UserResponse user;
    private UserResponse assistedBy;
    private String type;
    private Date timeJoined;
    private String table;
}
