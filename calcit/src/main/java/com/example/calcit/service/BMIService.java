package com.example.calcit.service;

import com.example.calcit.model.BMI;

import java.util.List;

public interface BMIService {

    void saveOrUpdate(BMI bmiResult);

    void delete(int id);

    BMI get(int id);

    List<BMI> getAllBMIResults();

    List<BMI> getBMIResultsForUser(int userId);
}