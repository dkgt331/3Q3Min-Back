package demo.q3min.controller;

import demo.q3min.dto.UserUpdateDto;
import demo.q3min.entity.User;
import demo.q3min.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
//@RequiredArgsConstructor

public class UserController {

    @Autowired
    UserService userService;
    /*private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }*/

    @PostMapping("/signup")
    public CreateMemberResponse signUp(@RequestBody CreateMemberRequest request){

        User user=new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        Integer id = userService.signUp(user);
        return new CreateMemberResponse(id);
    }

    @GetMapping("/search/{id}")
    public Optional<User> findUser(@PathVariable int id){
        return userService.searchUser(id);
    }

    @PutMapping("/modify/{id}")
    public Map<String,Object> update(@PathVariable("id") Integer id, @RequestBody final UserUpdateDto userUpdateDto){
        Map<String, Object> response = new HashMap<>();
        Optional<User> findMember = userService.searchUser(id);
        int res=userService.update(id,userUpdateDto);
        if(res>0){
            response.put("result","SUCCESS");
            response.put("회원정보",findMember);
        }
        else{
            response.put("result","FAIL");
            response.put("reason", "일치하는 회원 정보 없음");
        }
        return response;
    }

    @Data
    static class CreateMemberRequest{
        private String email;
        private String password;
        public String getEmail(){
            return email;
        }
        public String getPassword() {
            return password;
        }
    }

    @Data
    static class CreateMemberResponse{
        private int id;
        public CreateMemberResponse(int id){
            this.id=id;
        }
    }

}
