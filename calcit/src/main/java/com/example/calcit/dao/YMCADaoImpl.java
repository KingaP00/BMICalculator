package com.example.calcit.dao;

import com.example.calcit.model.YMCA;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class YMCADaoImpl implements YMCADao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(YMCA ymcaResult) {
        sessionFactory.getCurrentSession().saveOrUpdate(ymcaResult);
    }

    @Override
    public void delete(int id) {
        YMCA ymcaResult = (YMCA) sessionFactory.getCurrentSession().load(YMCA.class, id);
        if (null != ymcaResult) {
            this.sessionFactory.getCurrentSession().delete(ymcaResult);
        }
    }

    @Override
    public YMCA get(int id) {
        return (YMCA) sessionFactory.getCurrentSession().get(YMCA.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<YMCA> getAllYMCAResults() {
        return sessionFactory.getCurrentSession().createQuery("FROM YMCA").list();
    }

    @SuppressWarnings("unchecked")
    public List<YMCA> getYMCAResultsForUser(int userId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM YMCA y WHERE y.userId=:userId")
                .setParameter("userId", userId)
                .list();
    }
}

