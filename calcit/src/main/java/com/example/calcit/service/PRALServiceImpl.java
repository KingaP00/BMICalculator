package com.example.calcit.service;

import com.example.calcit.dao.PRALDao;
import com.example.calcit.model.PRAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PRALServiceImpl implements PRALService {

    @Autowired
    private PRALDao pralDao;

    @Override
    public void saveOrUpdate(PRAL pralResult) {
        pralDao.saveOrUpdate(pralResult);
    }

    @Override
    public void delete(int id) {
        pralDao.delete(id);
    }

    @Override
    public PRAL get(int id) {
        return pralDao.get(id);
    }

    @Override
    public List<PRAL> getAllPRALResults() {
        return pralDao.getAllPRALResults();
    }

    @Override
    public List<PRAL> getPRALResultsForUser(int userId) {
        return pralDao.getPRALResultsForUser(userId);
    }
}
