package demo.q3min.service;

import demo.q3min.dto.UserUpdateDto;
import demo.q3min.entity.User;
import demo.q3min.enums.Mbti;
import demo.q3min.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
//@Transactional

class UserServiceIntegrationTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    void 회원가입(){
        User user= new User();
        user.setName("대체뭐야");

        Integer saveId = userService.signUp(user);

        User findUser = userService.searchUser(saveId).get();
        assertThat(user.getName()).isEqualTo(findUser.getName());
    }

    @Test
    void findOne(){
        User user1 =new User();
        user1.setName("test1");
        userService.signUp(user1);

        User user2=new User();
        user2.setName("test2");
        userService.signUp(user2);

        User result = userService.searchUser(user1.getId()).get();
        System.out.println("The ID IS " + user1.getId());
        assertThat(user1).isEqualTo(result);
    }

    @Test
    void 회원수정(){
        UserUpdateDto testDto = new UserUpdateDto();
        testDto.ConstructDto("UUU","TTT","PPP",Mbti.ESFJ);

        userService.update(2,testDto);
        //User result=userService.searchUser(1).get();

    }
}
