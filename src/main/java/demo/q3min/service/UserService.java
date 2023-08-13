package demo.q3min.service;

import demo.q3min.entity.User;
import demo.q3min.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(String userId) {
        Optional<User> optionalUser = userRepository.findByUserId(userId);
        User user = optionalUser.get();
        return user;
    }
}
