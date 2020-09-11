package ru.bass2000.springbootsandbox.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectDTO {
    private String name;
    private String professorFirstName;
    private String professorMiddleName;
    private String professorLastName;
}
