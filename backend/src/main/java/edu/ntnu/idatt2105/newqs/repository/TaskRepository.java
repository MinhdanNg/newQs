package edu.ntnu.idatt2105.newqs.repository;

import edu.ntnu.idatt2105.newqs.entity.Subject;
import edu.ntnu.idatt2105.newqs.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long>
{
    List<Task> findTasksByTaskNrInAndSubject(Collection<Integer> taskNr, Subject subject);
}
