package demo.q3min.repository;

import demo.q3min.entity.User;

import java.util.*;

public class MemoryUserRepository implements UserRepository{
    private static Map<Integer, User> store = new HashMap<>();
    private static int sequence = 0;
    @Override
    public User save(User user) {
        user.setId(++sequence);
        store.put(user.getId(),user);
        return user;
    }

    @Override
    public Optional<User> findByID(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return store.values().stream()
                .filter(user->user.getEmail().equals(email))
                .findAny();
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream()
                .filter(user->user.getName().equals(name))
                .findAny();
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return Optional.ofNullable(store.get(username));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
