package org.example.dao;

import org.example.antity.User;

import org.example.dto.Animals;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static org.hibernate.resource.transaction.spi.TransactionStatus.ACTIVE;
import static org.hibernate.resource.transaction.spi.TransactionStatus.MARKED_ROLLBACK;

@Repository
public class UserDaoHiber implements UserDao {
   @Autowired
    SessionFactory sessionFactory;


@Transactional
    public void saveUser(String name, String lastName, int age) {
       sessionFactory.getCurrentSession().save(new User(name, lastName, age));
    }


@Transactional
    public List<User> getAllUsers() {
       TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
       return query.getResultList();
    }
@Transactional
    public User getUserById(long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
        query.setParameter("id", id);
        return  query.getSingleResult();
    }
    @Transactional
    public List<Animals> getAllAnimals() {
        return sessionFactory.getCurrentSession().createQuery("from Animals").getResultList();
    }

}
