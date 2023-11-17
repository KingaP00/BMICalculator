package com.example.calcit.dao;

import com.example.calcit.model.BMIResult;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BMIDaoImpl implements BMIDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(BMIResult bmiResult) {
        sessionFactory.getCurrentSession().saveOrUpdate(bmiResult);
    }

    @Override
    public void delete(int id) {
        BMIResult bmiResult = (BMIResult) sessionFactory.getCurrentSession().load(BMIResult.class, id);
        if (null != bmiResult) {
            this.sessionFactory.getCurrentSession().delete(bmiResult);
        }
    }

    @Override
    public BMIResult get(int id) {
        return (BMIResult) sessionFactory.getCurrentSession().get(BMIResult.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<BMIResult> getAllBMIResults() {
        return sessionFactory.getCurrentSession().createQuery("FROM BMIResult").list();
    }

    @SuppressWarnings("unchecked")
    public List<BMIResult> getBMIResultsForUser(int userId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM BMIResult b WHERE b.userId=:userId")
                .setParameter("userId", userId)
                .list();
    }
}
