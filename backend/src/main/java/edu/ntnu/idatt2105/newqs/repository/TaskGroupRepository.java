package edu.ntnu.idatt2105.newqs.repository;

import edu.ntnu.idatt2105.newqs.entity.TaskGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskGroupRepository extends CrudRepository<TaskGroup, Long>
{

}
