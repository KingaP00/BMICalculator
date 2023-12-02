package com.example.calcit.service;

import com.example.calcit.dao.PPMDao;
import com.example.calcit.model.PPM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PPMSservicelmpl implements PPMService {

    @Autowired
    private PPMDao ppmDao;

    @Override
    public void saveOrUpdate(PPM ppmResult) {
        ppmDao.saveOrUpdate(ppmResult);
    }

    @Override
    public void delete(int id) {
        ppmDao.delete(id);
    }

    @Override
    public PPM get(int id) {
        return ppmDao.get(id);
    }

    @Override
    public List<PPM> getAllPPMResults() {
        return ppmDao.getAllPPMResults();
    }

    @Override
    public List<PPM> getPPMResultsForUser(int userId) {
        return ppmDao.getPPMResultsForUser(userId);
    }

}