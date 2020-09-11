package ru.bass2000.springbootsandbox.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bass2000.springbootsandbox.model.dto.PersonDTO;
import ru.bass2000.springbootsandbox.model.entity.Person;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    @Mapping(ignore = true, target = "id")
    Person personDtoToPerson(PersonDTO dto);

}
