package ru.bass2000.springbootsandbox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bass2000.springbootsandbox.model.entity.User;
import ru.bass2000.springbootsandbox.repository.UsersRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository userRepository;

    @Override
    public String getUser() {
        List<User> all = (List<User>) userRepository.findAll();

        return all.get(0).toString();
    }
}
