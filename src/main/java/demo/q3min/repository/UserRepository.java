package demo.q3min.repository;

import demo.q3min.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findByID(int id);

    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
    Optional<User> findByUserName(String username);
    List<User> findAll();
}
