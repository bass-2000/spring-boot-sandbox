package ru.bass2000.springbootsandbox.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name = "USERS")
@ApiModel("Пример модели")
@NoArgsConstructor
public class User {
    @ApiModelProperty("Имя")
    String name;
    @ApiModelProperty("Описание")
    String description;
    @ApiModelProperty("Возвраст")
    Integer age;
    @Id
    @GeneratedValue
    private int id;
}
