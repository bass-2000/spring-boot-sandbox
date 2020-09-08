package ru.bass2000.springbootsandbox.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bass2000.springbootsandbox.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${application.api.uriPrefix}/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "Получить клиента")
    public String getUser() {
        return userService.getUser();
    }
}
