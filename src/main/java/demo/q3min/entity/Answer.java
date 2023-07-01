package demo.q3min.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "question", referencedColumnName = "id")
    private Question question;

    @Column(length = 1000)
    private String content;

    @Column
    private Date date;

}
