package edu.ntnu.idatt2105.newqs.repository;

import edu.ntnu.idatt2105.newqs.entity.QueueItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueItemRepository extends CrudRepository<QueueItem, Long>
{

}
