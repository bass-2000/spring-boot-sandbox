package ru.bass2000.springbootsandbox.service;

import liquibase.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bass2000.springbootsandbox.model.PersonType;
import ru.bass2000.springbootsandbox.model.dto.PersonDTO;
import ru.bass2000.springbootsandbox.model.dto.SubjectDTO;
import ru.bass2000.springbootsandbox.model.entity.Person;
import ru.bass2000.springbootsandbox.model.entity.Subject;
import ru.bass2000.springbootsandbox.repository.PersonsRepository;
import ru.bass2000.springbootsandbox.repository.SubjectsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectsServiceImpl implements SubjectsService {
    private final PersonsService personService;
    private final SubjectsRepository subjectsRepository;
    private final PersonsRepository personsRepository;

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> listOfSubjects = (List<Subject>) subjectsRepository.findAll();
        return listOfSubjects;
    }

    @Override
    public Subject addSubject(SubjectDTO subjectDTO) {
        PersonDTO professorDTO = new PersonDTO()
                .setFirstName(subjectDTO.getProfessorFirstName())
                .setMiddleName(subjectDTO.getProfessorMiddleName())
                .setLastName(subjectDTO.getProfessorLastName());
        Person professor = personService.getPersonByName(professorDTO, PersonType.PROFESSOR);
        return subjectsRepository.save(new Subject().setName(subjectDTO.getName()).setProfessor(professor));
    }


    @Override
    public void deleteSubject(int id) {
        subjectsRepository.deleteById(id);
    }

    @Override
    public Subject updateSubject(int id, SubjectDTO subjectDTO) {
        Subject subjectFromDB = subjectsRepository.findById(id).orElseThrow();
        Person professor = personsRepository.findByFirstNameIgnoreCaseAndMiddleNameIgnoreCaseAndLastNameIgnoreCase(
                subjectDTO.getProfessorFirstName(),
                subjectDTO.getProfessorMiddleName(),
                subjectDTO.getProfessorLastName());
        subjectFromDB
                .setName(StringUtil.isEmpty(subjectDTO.getName()) ?
                        subjectFromDB.getName()
                        : subjectDTO.getName())
                .setProfessor(professor == null ?
                        subjectFromDB.getProfessor()
                        : professor);

        return subjectsRepository.save(subjectFromDB);
    }
}
