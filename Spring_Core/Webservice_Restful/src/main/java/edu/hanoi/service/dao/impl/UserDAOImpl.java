package edu.hanoi.service.dao.impl;

import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.service.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {

    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    @Qualifier(value = "sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> list() {
        Session session = sessionFactory.getObject().openSession();
        try {
            Query query = session.createQuery("from User order by age desc");
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public String insert(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            Serializable value = session.save(user);
            LOGGER.info("Save user " + user.getUsername() + " done !" + value);
            session.flush();
            session.getTransaction().commit();
            return value.toString();
        } finally {
            session.close();
        }
    }

    @Override
    public User get(String username) {
        Session session = sessionFactory.getObject().openSession();
        try {
            return session.get(User.class, username);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(String name) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            User user = session.get(User.class, name);
            if (user != null) {
                session.delete(user);
            }
            session.flush();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.update(user);
            session.flush();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
