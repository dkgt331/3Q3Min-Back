package demo.q3min.repository;

import demo.q3min.entity.User;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRepositoryTest {


    MemoryUserRepository repository =new MemoryUserRepository();
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        User user = new User();
        user.setName("미도리");

        repository.save(user);

        User result=repository.findByID(user.getId()).get();
        System.out.println("result = " + (result==user));
    }


    @Test
    public void findByEmail(){
        User user1 = new User();
        user1.setName("쿠루루");
        user1.setEmail("qkralsdk991@naver.com");
        repository.save(user1);

        User user2 = new User();
        user2.setName("민필리아");
        user2.setEmail("elias0502@naver.com");
        repository.save(user2);

        User result = repository.findByEmail("qkralsdk991@naver.com").get();
        System.out.println("result = " + (result==user1));
    }
    //Optional<User> findByName(String name);
    //Optional<User> findByUserName(String username);
    @Test
    public void findAll(){
        User user1=new User();
        user1.setEmail("qkralsdk991@naver.com");
        repository.save(user1);

        User user2 = new User();
        user2.setEmail("elias0502@naver.com");
        repository.save(user2);

        List<User> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
