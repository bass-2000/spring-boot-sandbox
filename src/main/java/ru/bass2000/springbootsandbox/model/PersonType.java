package ru.bass2000.springbootsandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum PersonType {
    STUDENT(0, "STUDENT"),
    PROFESSOR(1, "PROFESSOR");

    private final int value;
    private final String type;

    public static PersonType getByValue(int value) {
        return Arrays.stream(values()).filter(status -> status.value == value).findFirst().orElse(null);
    }
}
