package ru.bass2000.springbootsandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSandboxApplication.class, args);
    }

}
