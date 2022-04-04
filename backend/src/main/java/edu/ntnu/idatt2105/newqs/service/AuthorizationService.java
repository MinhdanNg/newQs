package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.entity.User;
import edu.ntnu.idatt2105.newqs.repository.SubjectRepository;
import edu.ntnu.idatt2105.newqs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.AccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService
{
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UserRepository userRepository;

    public String getUserId()
    {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public void assertStudentGrant(long subjectId) throws AccessException
    {
        if(!(isStudentIn(subjectId) || isAssistantIn(subjectId) || isTeacher()))
        {
            throw new AccessException("Access denied");
        }
    }

    public void assertAssistantGrant(long subjectId) throws AccessException
    {
        if(!(isAssistantIn(subjectId) || isTeacher()))
        {
            throw new AccessException("Access denied");
        }
    }

    public void assertTeacherGrant() throws AccessException
    {
        if(!isTeacher())
        {
            throw new AccessException("Access denied");
        }
    }

    private boolean isStudentIn(long subjectId)
    {
        User student = userRepository.findById(getUserId()).orElseThrow();
        return subjectRepository.findById(subjectId).orElseThrow().getStudents().contains(student);
    }

    private boolean isAssistantIn(long subjectId)
    {
        User assistant = userRepository.findById(getUserId()).orElseThrow();
        return subjectRepository.findById(subjectId).orElseThrow().getAssistants().contains(assistant);
    }

    private boolean isTeacher()
    {
        return userRepository.findById(getUserId()).orElseThrow().getIsTeacher();
    }
}
