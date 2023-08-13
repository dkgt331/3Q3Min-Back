package demo.q3min.entity;


import demo.q3min.enums.Mbti;
import demo.q3min.enums.ProviderType;
import demo.q3min.enums.RoleType;
import demo.q3min.enums.ServiceProvider;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 64, unique = true)
    @NotNull
    private String userId;

    @Column(length = 100)
    private String email;

    @Column
    private boolean isEmailVerified;

    @Column
    private String profileImageUrl; // 이미지가 저장된 경로 저장

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

    public String getEmail() {
        return this.email;
    }

    public boolean getIsEmailVerified() {
        return this.isEmailVerified;
    }

    public String getName() {
        return this.name;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getProfileImageUrl() {
        return this.profileImageUrl;
    }

}
