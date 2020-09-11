package ru.bass2000.springbootsandbox.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.bass2000.springbootsandbox.model.PersonType;

import javax.persistence.*;


@Entity
@Data
@Table(name = "PERSONS")
@ApiModel("Модель пользователя")
@NoArgsConstructor
@Accessors(chain = true)
public class Person {
    @ApiModelProperty("Идентификатор пользователя")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ApiModelProperty("Имя")
    @Column(name = "first_name")
    private String firstName;
    @ApiModelProperty("Фамилия")
    @Column(name = "last_name")
    private String lastName;
    @ApiModelProperty("Отчество")
    @Column(name = "middle_name")
    private String middleName;
    @ApiModelProperty("Тип ученик/профессор")
    @Enumerated
    @Column(name = "type_id")
    private PersonType personType;

}
