package demo.q3min;

import demo.q3min.repository.JPAUserRepository;
import demo.q3min.repository.MemoryUserRepository;
import demo.q3min.repository.UserRepository;
import demo.q3min.service.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource=dataSource;
        this.em=em;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new JPAUserRepository(em);
    }
}
