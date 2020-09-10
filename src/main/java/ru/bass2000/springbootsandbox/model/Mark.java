package ru.bass2000.springbootsandbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Mark {
    A_PLUS(0, "A+ - Good job"),
    A(1, "A - Nice"),
    B(2, "B - Not Bad"),
    C(3, "C - Beware!"),
    E(4, "E -Oh, my!"),
    F(5, "F - You're in the army now");

    private final int value;
    private final String name;

    public static Mark getByValue(int value) {
        return Arrays.stream(values()).filter(status -> status.value == value).findFirst().orElse(null);
    }
}
