package edu.ntnu.idatt2105.newqs.model.queue;

import edu.ntnu.idatt2105.newqs.model.queueitem.QueueItemResponse;
import edu.ntnu.idatt2105.newqs.model.room.RoomResponse;

import java.util.List;

public class QueueResponse
{
    private long queueId;
    private boolean isActive;
    private RoomResponse room;
    private List<QueueItemResponse> items;
}
