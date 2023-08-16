package demo.q3min.service;

import demo.q3min.entity.User;
import demo.q3min.repository.MemoryUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    UserService userService;
    MemoryUserRepository userRepository;

    @BeforeEach
    public void beforeEach(){
        userRepository=new MemoryUserRepository();
        userService = new UserService(userRepository);
    }

    @AfterEach
    public void afterEach() {
        userRepository.clearStore();
    }

    @Test
    public void 회원가입(){
        User user =new User();
        user.setName("아오오니");

        Integer saveId = userService.signUp(user);

        User findUser=userService.searchUser(saveId).get();
        System.out.println("Result =" + (findUser==user));

    }
}
