package edu.ntnu.idatt2105.newqs.service;

import com.google.common.collect.Lists;
import edu.ntnu.idatt2105.newqs.entity.*;
import edu.ntnu.idatt2105.newqs.model.subject.*;
import edu.ntnu.idatt2105.newqs.model.tasks.TaskGroupRegisterRequest;
import edu.ntnu.idatt2105.newqs.repository.*;
import edu.ntnu.idatt2105.newqs.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    private TaskRepository taskRepository;
    @Autowired
    private QueueRepository queueRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public SubjectResponse register(SubjectRegisterRequest request)
    {
        List<User> teachers = userService.getOrCreate(request.getTeachersCSV(), true);
        List<User> assistants = userService.getOrCreate(request.getAssistantsCSV(), false);
        List<User> students = userService.getOrCreate(request.getStudentsCSV(), false);

        List<TaskGroup> taskGroups = new ArrayList<>();
        int taskNr = 1;
        for (TaskGroupRegisterRequest taskGroupRegisterRequest : request.getTaskGroups())
        {

            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < taskGroupRegisterRequest.getNumTasks(); i++)
            {
                Task task = new Task(taskNr);
                tasks.add(task);
                taskNr++;
            }
            taskRepository.saveAll(tasks);


            TaskGroup taskGroup = new TaskGroup(tasks, taskGroupRegisterRequest.getNumRequired());
            taskGroups.add(taskGroup);
        }
        taskGroupRepository.saveAll(taskGroups);

        Queue queue = new Queue();
        queue = queueRepository.save(queue);

        Subject subject = new Subject(request.getCode(), request.getName(), true, teachers, assistants, students, taskGroups, queue);
        subject = subjectRepository.save(subject);

        return Mapper.ToSubjectResponse(subject);
    }

    public SubjectResponse get(long subjectId)
    {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        return Mapper.ToSubjectResponse(subject);
    }

    public List<SubjectResponse> getAll()
    {
        List<Subject> subjects = Lists.newArrayList(subjectRepository.findAll());
        return Mapper.ToSubjectResponses(subjects);
    }

    public List<SubjectResponse> getWhereStudent(String studentId)
    {
        User student = userRepository.findById(studentId).orElseThrow();
        List<Subject> subjects = subjectRepository.findSubjectsByStudentsContains(student);
        return Mapper.ToSubjectResponses(subjects);
    }

    public List<SubjectResponse> getWhereAssistant(String assistantId)
    {
        User assistant = userRepository.findById(assistantId).orElseThrow();
        List<Subject> subjects = subjectRepository.findSubjectsByAssistantsContains(assistant);
        return Mapper.ToSubjectResponses(subjects);
    }

    public void activate(long subjectId)
    {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        subject.setActive(true);
        subjectRepository.save(subject);
    }

    public void archive(long subjectId)
    {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        subject.setActive(false);
        subjectRepository.save(subject);
    }

    public void delete(long subjectId)
    {
        subjectRepository.deleteById(subjectId);
    }

    public void addUsers(long subjectId, SubjectAddUsersRequest request)
    {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();

        List<User> teachers = userService.getOrCreate(request.getTeachersCSV(), true);
        List<User> assistants = userService.getOrCreate(request.getAssistantsCSV(), false);
        List<User> students = userService.getOrCreate(request.getStudentsCSV(), false);

        subject.getTeachers().addAll(teachers);
        subject.getAssistants().addAll(assistants);
        subject.getStudents().addAll(students);

        subjectRepository.save(subject);
    }

    public List<SubjectGetTaskOverviewResponse> getAllTaskOverview(long subjectId)
    {
        return null;
    }

    public SubjectGetTaskOverviewResponse getMyTaskOverview(long subjectId, String userId)
    {
        return null;
    }
}
