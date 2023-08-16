package demo.q3min.repository;

import demo.q3min.entity.User;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JPAUserRepository implements UserRepository{

    private final EntityManager em;

    public JPAUserRepository(EntityManager em){
        this.em=em;
    }

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public Optional<User> findByID(int id) {
        User user=em.find(User.class,id);
        return Optional.ofNullable(user);
    }

    public Optional<User> findByEmail(String email) {
        List<User> result=em.createQuery("select m from User m where m.email= :email",User.class)
                .setParameter("email",email)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> result=em.createQuery("select m from User m where m.name= :name",User.class)
                .setParameter("name",name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<User> findByUserName(String username) {
        List<User> result=em.createQuery("select m from User m where m.username= :username",User.class)
                .setParameter("username",username)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class)
                .getResultList();
    }
}
