package ru.bass2000.springbootsandbox.service;

import org.springframework.stereotype.Service;
import ru.bass2000.springbootsandbox.model.PersonType;
import ru.bass2000.springbootsandbox.model.dto.PersonDTO;
import ru.bass2000.springbootsandbox.model.entity.Person;

import java.util.List;

@Service
public interface PersonsService {

    List<Person> getAllPersons();

    Person getPersonById(int id);

    Person editPerson(int id, PersonDTO personDTO);

    Person addPerson(PersonDTO personDTO);

    Person getPersonByName(PersonDTO professorDTO, PersonType personType);

    void deletePerson(int id);
}
