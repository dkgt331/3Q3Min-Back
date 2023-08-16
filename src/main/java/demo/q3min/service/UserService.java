package demo.q3min.service;

import demo.q3min.dto.UserUpdateDto;
import demo.q3min.entity.User;
import demo.q3min.enums.Mbti;
import demo.q3min.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer signUp(User user) {
        validateDuplicateEmail(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateEmail(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                });
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> searchUser(int id) {
        return userRepository.findByID(id);
    }

    @Transactional
    public int update(Integer id, UserUpdateDto userUpdateDto) {
        Optional<User> target = userRepository.findByID(id);

        User user = target.get();
        user.setName(userUpdateDto.getName());
        user.setUsername(userUpdateDto.getUsername());
        user.setEmail(userUpdateDto.getEmail());
        user.setPassword(userUpdateDto.getPassword());
        user.setMbti(userUpdateDto.getMbti(userUpdateDto.mbtivalue));

        return 1;
    }
}


