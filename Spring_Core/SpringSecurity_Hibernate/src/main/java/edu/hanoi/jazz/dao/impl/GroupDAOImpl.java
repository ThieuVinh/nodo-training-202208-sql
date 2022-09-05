package edu.hanoi.jazz.dao.impl;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.model.Group;
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

@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {

    private final static Logger LOGGER = Logger.getLogger(GroupDAO.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void insert(Group group) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.save(group);
            session.flush();
            LOGGER.info("Save group " + group.getName() + " done !");
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Group> list(String pattem) {
        Session session = sessionFactory.getObject().openSession();
        if (pattem == null || pattem.length() < 1) {
            Query query = session.createQuery("from Group ");
            return (List<Group>) query.getResultList();
        }
        Criteria criteria = session.createCriteria(Group.class);
        criteria.add(Restrictions.like("name", "%" + pattem + "%", MatchMode.ANYWHERE));
        return new ArrayList<Group>(criteria.list());
    }

    @Override
    public Group get(int id) {
        Session session = sessionFactory.getObject().openSession();
        return session.get(Group.class, id);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            Group group = session.get(Group.class, id);
            session.delete(group);
            session.flush();
            LOGGER.info("Delete group " + group.getName() + " done !");
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Group group) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.merge(group);
            session.flush();
            LOGGER.info("Update group " + group.getName() + " done !");
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
