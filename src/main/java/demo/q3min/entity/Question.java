package demo.q3min.entity;


import jakarta.persistence.*;
import demo.q3min.enums.*;

import java.sql.Date;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @Column
    @Enumerated(EnumType.STRING)
    private QuestionCategory category;

    @Column(length = 1000)
    private String content;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;


}
