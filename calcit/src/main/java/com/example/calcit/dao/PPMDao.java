package com.example.calcit.dao;

import com.example.calcit.model.PPM;

import java.util.List;

public interface PPMDao {

    void saveOrUpdate(PPM ppmResult);

    void delete(int id);

    PPM get(int id);

    List<PPM> getAllPPMResults();

    List<PPM> getPPMResultsForUser(int userId);
}