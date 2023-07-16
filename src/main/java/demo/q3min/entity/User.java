package demo.q3min.entity;


import demo.q3min.enums.Mbti;
import demo.q3min.enums.ServiceProvider;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String email;

    @Column
    private String profileImage; // 이미지가 저장된 경로 저장

    @Column(length = 50)
    private String username;

    @Column(length = 20)
    private String role;

    @Column
    @Enumerated(EnumType.STRING)
    private Mbti mbti;

    @Column
    @Enumerated(EnumType.STRING)
    private ServiceProvider serviceProvider;

    @Column
    @CreationTimestamp
    private Date registerDate;

    public User() {

    }

    public String getRole() {
        return this.role;
    }

    public String getUsername() {
        return this.username;
    }

    @Builder
    public User(String email, String username, String serviceProvider, String role) {
        this.email = email;
        this.username = username;
        if (serviceProvider == "GOOGLE") {
            this.serviceProvider = ServiceProvider.GOOGLE;
        } else if (serviceProvider == "NAVER") {
            this.serviceProvider = ServiceProvider.NAVER;
        } else {
            this.serviceProvider = ServiceProvider.KAKAO;
        }
        this.role = role;
    }

}
