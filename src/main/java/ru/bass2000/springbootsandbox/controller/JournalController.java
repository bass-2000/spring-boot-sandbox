package ru.bass2000.springbootsandbox.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bass2000.springbootsandbox.model.dto.JournalDTO;
import ru.bass2000.springbootsandbox.model.entity.Journal;
import ru.bass2000.springbootsandbox.service.JournalService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${application.api.uriPrefix}/journal")
public class JournalController {
    private final JournalService journalService;

    @GetMapping
    @ApiOperation(value = "Получить список всех оценок")
    public List<Journal> getAllPersons() {
        return journalService.getAllJournalRecords();
    }

    @PostMapping
    @ApiOperation(value = "Добавить запись в журнал")
    public Journal addJournalRecord(@RequestBody JournalDTO journalDTO) {
        return journalService.addRecord(journalDTO);
    }

    @PutMapping(value = "/{id}")
    @ApiParam(name = "id", value = "Идентификатор записи в журнале")
    @ApiOperation(value = "Редактировать запись в журнале")
    public Journal updateJournalRecord(@PathVariable int id,
                                       @RequestBody JournalDTO journalDTO) {
        return journalService.updateRecord(id, journalDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ApiParam(name = "id", value = "Идентификатор записи в журнале")
    @ApiOperation(value = "Удалить запись в журнале")
    public void deleteSubject(@PathVariable int id) {
        journalService.deleteRecord(id);
    }

}
