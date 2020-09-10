package ru.bass2000.springbootsandbox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bass2000.springbootsandbox.model.entity.Person;

@Repository
public interface PersonsRepository extends CrudRepository<Person, Integer> {
}
