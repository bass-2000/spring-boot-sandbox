package ru.bass2000.springbootsandbox.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.bass2000.springbootsandbox.model.Mark;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class JournalDTO {
    String studentFirstName;
    String studentMiddleName;
    String studentLastName;
    String subjectName;
    Mark mark;
}
