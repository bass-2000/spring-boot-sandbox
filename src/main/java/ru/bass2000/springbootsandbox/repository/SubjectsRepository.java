package ru.bass2000.springbootsandbox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bass2000.springbootsandbox.model.entity.Subject;

@Repository
public interface SubjectsRepository extends CrudRepository<Subject, Integer> {

    Subject findByNameIgnoreCase(String name);
}
