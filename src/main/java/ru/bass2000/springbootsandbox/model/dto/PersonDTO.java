package ru.bass2000.springbootsandbox.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.bass2000.springbootsandbox.model.PersonType;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class PersonDTO {
    private String firstName;
    private String lastName;
    private String middleName;
    private PersonType personType;
}
