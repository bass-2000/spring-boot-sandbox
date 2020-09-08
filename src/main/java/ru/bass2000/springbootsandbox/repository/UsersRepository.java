package ru.bass2000.springbootsandbox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bass2000.springbootsandbox.model.entity.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
}
