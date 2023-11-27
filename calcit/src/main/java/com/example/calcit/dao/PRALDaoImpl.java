package com.example.calcit.dao;

import com.example.calcit.model.PRAL;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PRALDaoImpl implements PRALDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(PRAL pralResult) {
        sessionFactory.getCurrentSession().saveOrUpdate(pralResult);
    }

    @Override
    public void delete(int id) {
        PRAL pralResult = (PRAL) sessionFactory.getCurrentSession().load(PRAL.class, id);
        if (pralResult != null) {
            this.sessionFactory.getCurrentSession().delete(pralResult);
        }
    }
    @Override
    public PRAL get(int id) {
        return (PRAL) sessionFactory.getCurrentSession().get(PRAL.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<PRAL> getAllPRALResults() {
        return sessionFactory.getCurrentSession().createQuery("FROM PRAL").list();
    }

    @SuppressWarnings("unchecked")
    public List<PRAL> getPRALResultsForUser(int userId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM PRAL b WHERE b.userId=:userId")
                .setParameter("userId", userId)
                .list();
    }

   

}
