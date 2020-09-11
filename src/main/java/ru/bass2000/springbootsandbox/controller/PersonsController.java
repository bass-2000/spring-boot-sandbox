package ru.bass2000.springbootsandbox.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bass2000.springbootsandbox.model.dto.PersonDTO;
import ru.bass2000.springbootsandbox.model.entity.Person;
import ru.bass2000.springbootsandbox.service.PersonsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${application.api.uriPrefix}/person")
public class PersonsController {
    private final PersonsService personService;

    @GetMapping
    @ApiOperation(value = "Получить список всех пользователей")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "/{id}")
    @ApiParam(name = "id", value = "Идентификатор пользователя")
    @ApiOperation(value = "Получить пользователя по ID")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    @ApiOperation(value = "Добавить нового пользователя")
    public Person addPerson(@RequestBody PersonDTO personDTO) {
        return personService.addPerson(personDTO);
    }

    @PutMapping(value = "/{id}")
    @ApiParam(name = "id", value = "Идентификатор пользователя")
    @ApiOperation(value = "Редактировать пользователя")
    public Person updatePerson(@PathVariable int id,
                               @RequestBody PersonDTO personDTO) {
        return personService.editPerson(id, personDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ApiParam(name = "id", value = "Идентификатор пользователя")
    @ApiOperation(value = "Удалить пользователя")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }
}
