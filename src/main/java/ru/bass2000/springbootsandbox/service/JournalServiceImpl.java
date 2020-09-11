package ru.bass2000.springbootsandbox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import ru.bass2000.springbootsandbox.model.PersonType;
import ru.bass2000.springbootsandbox.model.dto.JournalDTO;
import ru.bass2000.springbootsandbox.model.dto.PersonDTO;
import ru.bass2000.springbootsandbox.model.entity.Journal;
import ru.bass2000.springbootsandbox.model.entity.Person;
import ru.bass2000.springbootsandbox.model.entity.Subject;
import ru.bass2000.springbootsandbox.repository.JournalRepository;
import ru.bass2000.springbootsandbox.repository.SubjectsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JournalServiceImpl implements JournalService {
    private final PersonsService personService;
    private final SubjectsRepository subjectsRepository;
    private final JournalRepository journalRepository;
    private final ConversionService conversionService;

    @Override
    public List<Journal> getAllJournalRecords() {
        return (List<Journal>) journalRepository.findAll();
    }

    @Override
    public Journal addRecord(JournalDTO journalDTO) {
        PersonDTO student = conversionService.convert(journalDTO, PersonDTO.class);
        if (student == null) {
            throw new IllegalArgumentException("Просьба ввести данные студента");
        }
        Person studentFromDB = personService.getPersonByName(student, PersonType.STUDENT);
        Journal journal = new Journal()
                .setMark(journalDTO.getMark())
                .setStudent(studentFromDB);
        Subject subject = subjectsRepository.findByNameIgnoreCase(journalDTO.getSubjectName());
        journal.setSubject(subject);
        return journalRepository.save(journal);

    }

    @Override
    public Journal updateRecord(int id, JournalDTO journalDTO) {
        Journal journalFromDB = journalRepository.findById(id).orElseThrow();
        if (!StringUtils.isEmpty(journalDTO.getSubjectName())) {
            Subject subject = subjectsRepository.findByNameIgnoreCase(journalDTO.getSubjectName());
            journalFromDB.setSubject(subject);
        }
        PersonDTO studentDto = conversionService.convert(journalDTO, PersonDTO.class);
        if (journalDTO.getMark() != null) {
            journalFromDB.setMark(journalDTO.getMark());
        }
        if (studentDto != null) {
            Person student = personService.getPersonByName(studentDto, PersonType.STUDENT);
            journalFromDB.setStudent(student);
        }
        return journalRepository.save(journalFromDB);
    }

    @Override
    public void deleteRecord(int id) {
        journalRepository.deleteById(id);
    }
}
