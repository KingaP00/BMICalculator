package com.example.calcit.dao;

import com.example.calcit.model.PPM;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PPMDaompl implements PPMDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Object ppmResult;

    @Override
    public void saveOrUpdate(PPM ppmResult) {
        sessionFactory.getCurrentSession().saveOrUpdate(ppmResult);
    }

    @Override
    public void delete(int id) {
        PPM pmiResult = (PPM) sessionFactory.getCurrentSession().load(PPM.class, id);
        if (null != ppmResult) {
            this.sessionFactory.getCurrentSession().delete(ppmResult);
        }
    }

    @Override
    public PPM get(int id) {
        return (PPM) sessionFactory.getCurrentSession().get(PPM.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<PPM> getAllPPMResults() {
        return sessionFactory.getCurrentSession().createQuery("FROM PPM").list();
    }

    @SuppressWarnings("unchecked")
    public List<PPM> getPPMResultsForUser(int userId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM PPM b WHERE b.userId=:userId")
                .setParameter("userId", userId)
                .list();
    }
}
