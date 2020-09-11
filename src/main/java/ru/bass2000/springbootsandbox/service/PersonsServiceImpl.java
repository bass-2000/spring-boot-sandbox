package ru.bass2000.springbootsandbox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import ru.bass2000.springbootsandbox.model.PersonType;
import ru.bass2000.springbootsandbox.model.dto.PersonDTO;
import ru.bass2000.springbootsandbox.model.entity.Person;
import ru.bass2000.springbootsandbox.model.mapper.EntityMapper;
import ru.bass2000.springbootsandbox.repository.PersonsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonsServiceImpl implements PersonsService {
    private final PersonsRepository personsRepository;

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personsRepository.findAll();
    }

    @Override
    public Person getPersonById(int id) {
        return personsRepository.findById(id).get();
    }

    @Override
    public Person editPerson(int id, PersonDTO personDTO) {
        Person personFromDB = personsRepository.findById(id).get();
        personFromDB.setFirstName(StringUtils.isEmpty(personDTO.getFirstName()) ?
                personFromDB.getFirstName() :
                personDTO.getFirstName());
        personFromDB.setMiddleName(StringUtils.isEmpty(personDTO.getMiddleName()) ?
                personFromDB.getMiddleName() :
                personDTO.getMiddleName());
        personFromDB.setLastName(StringUtils.isEmpty(personDTO.getLastName()) ?
                personFromDB.getLastName() :
                personDTO.getLastName());
        personFromDB.setPersonType(personDTO.getPersonType() == null ?
                personFromDB.getPersonType() :
                personDTO.getPersonType());
        return personsRepository.save(personFromDB);
    }

    public Person getPersonByName(PersonDTO professorDTO, PersonType personType) {
        if (StringUtils.isEmpty(professorDTO.getFirstName()) ||
                StringUtils.isEmpty(professorDTO.getLastName()) ||
                StringUtils.isEmpty(professorDTO.getMiddleName())) {
            throw new IllegalArgumentException("Please enter full professor f.name, m.name, l.name");
        }
        Person professor = personsRepository.findByFirstNameIgnoreCaseAndMiddleNameIgnoreCaseAndLastNameIgnoreCase(
                professorDTO.getFirstName(),
                professorDTO.getMiddleName(),
                professorDTO.getLastName());
        if (professor == null || !professor.getPersonType().equals(personType)) {
            throw new EntityNotFoundException("No such " + personType.getType());
        }
        return professor;
    }

    @Override
    public Person addPerson(PersonDTO personDTO) {
        return personsRepository.save(EntityMapper.MAPPER.personDtoToPerson(personDTO));
    }

    @Override
    public void deletePerson(int id) {
        personsRepository.deleteById(id);
    }
}
