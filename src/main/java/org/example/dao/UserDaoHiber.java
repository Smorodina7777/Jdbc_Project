package org.example.dao;

import org.example.Config;
import org.example.antity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

import static org.hibernate.resource.transaction.spi.TransactionStatus.ACTIVE;
import static org.hibernate.resource.transaction.spi.TransactionStatus.MARKED_ROLLBACK;

@Repository
public class UserDaoHiber implements UserDao {
   @Autowired
    SessionFactory sessionFactory;

    public void dropUserTable() {
        Transaction transaction = null;
        try (Session session = Config.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS users");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }
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
}
