package com.example.calcit.service;

import com.example.calcit.model.YMCA;

import java.util.List;

public interface YMCAService {

    void saveOrUpdate(YMCA ymcaResult);

    void delete(int id);

    YMCA get(int id);

    List<YMCA> getAllYMCAResults();

    List<YMCA> getYMCAResultsForUser(int userId);
}

