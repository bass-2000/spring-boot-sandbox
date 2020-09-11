package ru.bass2000.springbootsandbox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bass2000.springbootsandbox.model.entity.Journal;

@Repository
public interface JournalRepository extends CrudRepository<Journal, Integer> {
}
