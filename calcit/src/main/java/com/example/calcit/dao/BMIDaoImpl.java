package com.example.calcit.dao;

import com.example.calcit.model.BMI;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BMIDaoImpl implements BMIDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(BMI bmiResult) {
        sessionFactory.getCurrentSession().saveOrUpdate(bmiResult);
    }
           
    @Override
    public void delete(int id) {
        BMI bmiResult = (BMI) sessionFactory.getCurrentSession().load(BMI.class, id);
        if (null != bmiResult) {
            this.sessionFactory.getCurrentSession().delete(bmiResult);
        }
    }

    @Override
    public BMI get(int id) {
        return (BMI) sessionFactory.getCurrentSession().get(BMI.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<BMI> getAllBMIResults() {
        return sessionFactory.getCurrentSession().createQuery("FROM BMI").list();
    }

    @SuppressWarnings("unchecked")
    public List<BMI> getBMIResultsForUser(int userId) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM BMI b WHERE b.userId=:userId")
                .setParameter("userId", userId)
                .list();
    }
}
