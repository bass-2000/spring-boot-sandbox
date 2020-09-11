package ru.bass2000.springbootsandbox.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@ApiModel("Модель дисциплины")
@NoArgsConstructor
@Accessors(chain = true)
public class Subject {
    @ApiModelProperty("Идентификатор дисциплины")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiModelProperty("Название дисциплины")
    private String name;

    @ApiModelProperty("Преподаватель")
    @ManyToOne(optional = false)
    @JoinColumn(name = "professor_id", nullable = false)
    private Person professor;
}
