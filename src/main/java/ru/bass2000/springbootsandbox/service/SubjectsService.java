package ru.bass2000.springbootsandbox.service;

import org.springframework.stereotype.Service;
import ru.bass2000.springbootsandbox.model.dto.SubjectDTO;
import ru.bass2000.springbootsandbox.model.entity.Subject;

import java.util.List;

@Service
public interface SubjectsService {
    List<Subject> getAllSubjects();

    Subject addSubject(SubjectDTO subjectDTO);

    void deleteSubject(int id);

    Subject updateSubject(int id, SubjectDTO subjectDTO);
}
