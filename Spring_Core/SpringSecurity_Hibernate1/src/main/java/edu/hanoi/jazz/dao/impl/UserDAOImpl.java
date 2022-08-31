package edu.hanoi.jazz.dao.impl;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.model.Group;
import edu.hanoi.jazz.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {

    private final static Logger LOGGER = Logger.getLogger(GroupDAO.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void insert(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.save(user);
            session.flush();
            LOGGER.info("Save user " + user.getUsername() + " done !");
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> list(Integer group) {
        Session session = sessionFactory.getObject().openSession();
        if (group == null || group < 0) {
            Query query = session.createQuery("from User ");
            return (List<User>) query.getResultList();
        }
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("groupId", group));
        return new ArrayList<User>(criteria.list());
    }

    @Override
    public User get(String username) {
        Session session = sessionFactory.getObject().openSession();
        return session.get(User.class, username);
    }

    @Override
    public void delete(String username) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            User user = session.get(User.class, username);
            session.delete(user);
            session.flush();
            LOGGER.info("Delete user " + user.getUsername() + " done !");
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
            session.merge(user);
            session.flush();
            LOGGER.info("Update user " + user.getUsername() + " done !");
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

}
