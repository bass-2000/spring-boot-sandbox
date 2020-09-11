package ru.bass2000.springbootsandbox.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.bass2000.springbootsandbox.model.Mark;

import javax.persistence.*;

@Entity
@Data
@Table(name = "JOURNAL")
@ApiModel("Модель журнала оценок")
@NoArgsConstructor
@Accessors(chain = true)
public class Journal {
    @ApiModelProperty("Идентификатор записи в журнале")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiModelProperty("Студент")
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Person student;

    @ApiModelProperty("Дисциплина")
    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ApiModelProperty("Оценка")
    @Enumerated
    @Column(name = "mark_id")
    private Mark mark;
}
