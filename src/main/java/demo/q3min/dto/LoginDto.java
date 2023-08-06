package demo.q3min.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return "";
    }

}
