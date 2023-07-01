package demo.q3min.entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @Column
    private Time time;

}
