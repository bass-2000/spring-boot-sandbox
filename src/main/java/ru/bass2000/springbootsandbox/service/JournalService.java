package ru.bass2000.springbootsandbox.service;

import org.springframework.stereotype.Service;
import ru.bass2000.springbootsandbox.model.dto.JournalDTO;
import ru.bass2000.springbootsandbox.model.entity.Journal;

import java.util.List;

@Service
public interface JournalService {
    List<Journal> getAllJournalRecords();

    Journal addRecord(JournalDTO journalDTO);

    Journal updateRecord(int id, JournalDTO journalDTO);

    void deleteRecord(int id);
}
