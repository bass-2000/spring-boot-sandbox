package ru.bass2000.springbootsandbox.model.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;
import ru.bass2000.springbootsandbox.model.dto.JournalDTO;
import ru.bass2000.springbootsandbox.model.dto.PersonDTO;

@Component
public class JournalDtoToPersonDTO implements Converter<JournalDTO, PersonDTO> {
    @Override
    public PersonDTO convert(JournalDTO source) {
        if (source == null ||
                (StringUtils.isEmpty(source.getStudentFirstName()) ||
                        StringUtils.isEmpty(source.getStudentMiddleName()) ||
                        StringUtils.isEmpty(source.getStudentLastName()))) {
            return null;
        }
        return new PersonDTO()
                .setFirstName(source.getStudentFirstName())
                .setMiddleName(source.getStudentMiddleName())
                .setLastName(source.getStudentLastName());
    }
}
