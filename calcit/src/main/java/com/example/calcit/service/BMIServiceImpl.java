package com.example.calcit.service;

import com.example.calcit.dao.BMIDao;
import com.example.calcit.model.BMIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BMIServiceImpl implements BMIService {

    @Autowired
    private BMIDao bmiDao;

    @Override
    public void saveOrUpdate(BMIResult bmiResult) {
        bmiDao.saveOrUpdate(bmiResult);
    }

    @Override
    public void delete(int id) {
        bmiDao.delete(id);
    }

    @Override
    public BMIResult get(int id) {
        return bmiDao.get(id);
    }

    @Override
    public List<BMIResult> getAllBMIResults() {
        return bmiDao.getAllBMIResults();
    }

    @Override
    public List<BMIResult> getBMIResultsForUser(int userId) {
        return bmiDao.getBMIResultsForUser(userId);
    }
}