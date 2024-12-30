package web.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import web.model.User;

@Repository
public class UserDaoImp implements UserDao {

    private EntityManager em;
    @SuppressWarnings("unused")
    private final EntityManagerFactory entityManagerFactory;

    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User all", User.class).getResultList();
    }

    @Override
    public void removeUser(Long id) {
        em.getTransaction().begin();
        em.remove(getUser(id));
        em.getTransaction().commit();
    }

    @Override
    public void updateUser(Long id, User newUser) {
        em.getTransaction().begin();
        em.merge(new User(id, newUser.getFirstName(), newUser.getLastName()));
        em.getTransaction().commit();
    }
}
