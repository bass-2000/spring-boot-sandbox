package ru.bass2000.springbootsandbox.service;

import org.springframework.stereotype.Service;
import ru.bass2000.springbootsandbox.model.dto.PersonDTO;
import ru.bass2000.springbootsandbox.model.entity.Person;

import java.util.List;

@Service
public interface PersonService {

    List<Person> getAllPersons();

    Person getPersonById(int id);

    Person editPerson(int id, PersonDTO personDTO);

    Person addPerson(PersonDTO personDTO);

    void deletePerson(int id);
}
