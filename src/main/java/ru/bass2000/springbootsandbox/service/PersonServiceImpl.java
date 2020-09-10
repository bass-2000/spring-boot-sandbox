package ru.bass2000.springbootsandbox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import ru.bass2000.springbootsandbox.model.dto.PersonDTO;
import ru.bass2000.springbootsandbox.model.entity.Person;
import ru.bass2000.springbootsandbox.model.mapper.EntityMapper;
import ru.bass2000.springbootsandbox.repository.PersonsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
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

    @Override
    public Person addPerson(PersonDTO personDTO) {
        return personsRepository.save(EntityMapper.MAPPER.personDtoToPerson(personDTO));
    }

    @Override
    public void deletePerson(int id) {
        Person personToDelete = personsRepository.findById(id).get();
        personsRepository.delete(personToDelete);
    }
}
