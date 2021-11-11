package com.springboot.springbootfirst.dao;

import com.springboot.springbootfirst.model.Role;
import com.springboot.springbootfirst.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(Long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public User getUserByName(String email) {
        User user = em.createQuery("SELECT u from User u WHERE u.email = :email", User.class).
                setParameter("email", email).getSingleResult();
        return user;
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        em.remove(getUser(id));
    }


    @Override
    public List<User> listUsers() {
        return em.createQuery("from User").getResultList();
    }


    @Transactional
    @Override
    public void changeEmail(Long id, String newEmail) {
        getUser(id).setEmail(newEmail);
    }

    @Transactional
    @Override
    public void changePassword(Long id, String newPassword) {
        getUser(id).setPassword(newPassword);
    }

    @Transactional
    @Override
    public void changeFirstname(Long id, String newFirstname) {
        getUser(id).setFirstname(newFirstname);
    }

    @Transactional
    @Override
    public void changeLastname(Long id, String newLastname) {
        getUser(id).setLastname(newLastname);
    }

    @Transactional
    @Override
    public void changeAge(Long id, Integer newAge) {
        getUser(id).setAge(newAge);
    }

    @Transactional
    @Override
    public void changeRoles(Long id, Set<Role> newRoles) {
        getUser(id).setRoles(newRoles);
    }
}
