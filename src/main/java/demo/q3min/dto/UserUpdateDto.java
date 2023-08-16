package demo.q3min.dto;

import demo.q3min.enums.Mbti;
import lombok.Data;

@Data
public class UserUpdateDto {
    public String name, username, email, password, mbtivalue;
    public Mbti mbti;

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public Mbti getMbti(String mbtivalue){
        Mbti mbti=Mbti.valueOf(mbtivalue);
        this.mbti=mbti;
        return this.mbti;}

    public void ConstructDto(String username, String email, String password, Mbti mbti){
        this.name="서비스테스트";
        this.username=username;
        this.email=email;
        this.password=password;
        this.mbti=mbti;
    }
}

/*
(
}Optional<String> name, Optional<String> username, Optional<String> email, Optional<Mbti> mbti) {
}
*/
