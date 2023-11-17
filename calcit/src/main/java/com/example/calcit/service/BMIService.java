package com.example.calcit.service;

import com.example.calcit.model.BMIResult;

import java.util.List;

public interface BMIService {

    void saveOrUpdate(BMIResult bmiResult);

    void delete(int id);

    BMIResult get(int id);

    List<BMIResult> getAllBMIResults();

    List<BMIResult> getBMIResultsForUser(int userId);
}