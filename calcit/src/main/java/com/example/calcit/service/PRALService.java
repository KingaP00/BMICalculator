package com.example.calcit.service;

import com.example.calcit.model.PRAL;

import java.util.List;

public interface PRALService {
    
    void saveOrUpdate(PRAL pralResult);

    void delete(int id);

    PRAL get(int id);

    List<PRAL> getAllPRALResults();

    List<PRAL> getPRALResultsForUser(int userId);
}
