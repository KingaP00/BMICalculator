package com.example.calcit.dao;

import com.example.calcit.model.BMIResult;

import java.util.List;

public interface BMIDao {

    void saveOrUpdate(BMIResult bmiResult);

    void delete(int id);

    BMIResult get(int id);

    List<BMIResult> getAllBMIResults();

    List<BMIResult> getBMIResultsForUser(int userId);
}
