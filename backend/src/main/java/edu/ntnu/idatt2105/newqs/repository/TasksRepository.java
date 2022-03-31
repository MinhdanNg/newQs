package edu.ntnu.idatt2105.newqs.repository;

import edu.ntnu.idatt2105.newqs.entity.Tasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends CrudRepository<Tasks, Long>
{

}
