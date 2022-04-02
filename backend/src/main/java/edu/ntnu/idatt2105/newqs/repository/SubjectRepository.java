package edu.ntnu.idatt2105.newqs.repository;

import edu.ntnu.idatt2105.newqs.entity.Subject;
import edu.ntnu.idatt2105.newqs.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>
{
    List<Subject> findSubjectsByStudentsContains(User student);

    List<Subject> findSubjectsByAssistantsContains(User assistant);
}
