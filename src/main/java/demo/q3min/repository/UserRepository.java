package demo.q3min.repository;

import demo.q3min.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);
    Optional<User> findByUserId(String userId);
}
