package ru.bass2000.springbootsandbox.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bass2000.springbootsandbox.model.dto.SubjectDTO;
import ru.bass2000.springbootsandbox.model.entity.Subject;
import ru.bass2000.springbootsandbox.service.SubjectsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${application.api.uriPrefix}/subject")
public class SubjectsController {
    private final SubjectsService subjectsService;

    @GetMapping
    @ApiOperation(value = "Получить список всех дисциплин")
    public List<Subject> getAllSubjects() {
        return subjectsService.getAllSubjects();
    }

    @PostMapping
    @ApiOperation(value = "Добавить дисциплину")
    public Subject addSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectsService.addSubject(subjectDTO);
    }

    @PutMapping(value = "/{id}")
    @ApiParam(name = "id", value = "Идентификатор дисциплины")
    @ApiOperation(value = "Редактировать дисциплину")
    public Subject updateSubject(@PathVariable int id, @RequestBody SubjectDTO subjectDTO) {
        return subjectsService.updateSubject(id, subjectDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ApiParam(name = "id", value = "Идентификатор дисциплины")
    @ApiOperation(value = "Удалить дисциплину")
    public void deleteSubject(@PathVariable int id) {
        subjectsService.deleteSubject(id);
    }

}
