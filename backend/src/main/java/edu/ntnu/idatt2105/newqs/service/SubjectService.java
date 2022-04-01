package edu.ntnu.idatt2105.newqs.service;

import com.google.common.collect.Lists;
import edu.ntnu.idatt2105.newqs.entity.*;
import edu.ntnu.idatt2105.newqs.model.subject.*;
import edu.ntnu.idatt2105.newqs.repository.QueueRepository;
import edu.ntnu.idatt2105.newqs.repository.SubjectRepository;
import edu.ntnu.idatt2105.newqs.repository.TaskGroupRepository;
import edu.ntnu.idatt2105.newqs.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService
{
    private static final Logger LOGGER = LogManager.getLogger(SubjectService.class);
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TaskGroupRepository taskGroupRepository;
    @Autowired
    private QueueRepository queueRepository;
    @Autowired
    private UserService userService;

    public SubjectResponse register(SubjectRegisterRequest request)
    {
        List<User> teachers = userService.getOrCreate(request.getTeachersCSV(), true);
        List<User> assistants = userService.getOrCreate(request.getAssistantsCSV(), false);
        List<User> students = userService.getOrCreate(request.getStudentsCSV(), false);

        List<TaskGroup> tasks = request.getTasks().stream().map(taskGroupRequest -> new TaskGroup(taskGroupRequest.getNumTasks(), taskGroupRequest.getNumRequired())).collect(Collectors.toList());
        tasks = Lists.newArrayList(taskGroupRepository.saveAll(tasks));

        Queue queue = new Queue();
        queue = queueRepository.save(queue);

        Subject subject = new Subject(request.getCode(), request.getName(), true, teachers, assistants, students, tasks, queue);
        subject = subjectRepository.save(subject);

        return Mapper.ToSubjectResponse(subject);
    }

    public SubjectResponse get(SubjectRequest request)
    {
        Optional<Subject> optionalSubject = subjectRepository.findById(request.getSubjectId());
        if (optionalSubject.isEmpty())
        {
            return null;
        }
        return Mapper.ToSubjectResponse(optionalSubject.get());
    }

    public void activate(SubjectRequest request)
    {

    }

    public void archive(SubjectRequest request)
    {

    }

    public void delete(SubjectRequest request)
    {

    }

    public void addUsers(SubjectAddUsersRequest request)
    {

    }

    public SubjectGetTaskOverviewResponse getTaskOverview(SubjectGetTaskOverviewRequest request)
    {
        return null;
    }

    public List<SubjectGetTaskOverviewResponse> getAllTaskOverview(SubjectRequest request)
    {
        return null;
    }
}
