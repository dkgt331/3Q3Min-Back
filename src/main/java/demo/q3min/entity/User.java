package demo.q3min.entity;


import demo.q3min.enums.*;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String email;

    @Column
    private String profileImage; // 이미지가 저장된 경로 저장

    @Column(length = 50)
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Mbti mbti;

    @Column
    @Enumerated(EnumType.STRING)
    private ServiceProvider serviceProvider;

    @Column
    private Date registerDate;

}
