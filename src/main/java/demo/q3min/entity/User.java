package demo.q3min.entity;


import demo.q3min.enums.Mbti;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Column(length = 100)
    private String password;

    @Column(length = 50)
    private String name;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Column
    @Enumerated(EnumType.STRING)
    private Mbti mbti;

    @Column
    @Enumerated(EnumType.STRING)
    private ProviderType providerType;

    @Column
    @CreationTimestamp
    private Date registerDate;

    @Column
    @UpdateTimestamp
    private Date modifiedDate;

    public User() {

    }

    public int getId() {
        return this.id;
    }

    public RoleType getRoleType() {
        return this.roleType;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}
    public Mbti getMbti(){return this.mbti;}
    public void setId(int id){
        this.id=id;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setEmail(String email) {
        this.email = email;}

    public void setPassword(String password){
        this.password=password;
    }

    public void setMbti(Mbti mbti){

        this.mbti=mbti;
    }

    public void setModifiedDate(Date modifiedDate){
        this.modifiedDate=modifiedDate;
    }

}
