package com.example.calcit.service;

import com.example.calcit.dao.YMCADao;
import com.example.calcit.model.YMCA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class YMCAServiceImpl implements YMCAService {

    @Autowired
    private YMCADao ymcaDao;

    @Override
    public void saveOrUpdate(YMCA ymcaResult) {
        ymcaDao.saveOrUpdate(ymcaResult);
    }

    @Override
    public void delete(int id) {
        ymcaDao.delete(id);
    }

    @Override
    public YMCA get(int id) {
        return ymcaDao.get(id);
    }

    @Override
    public List<YMCA> getAllYMCAResults() {
        return ymcaDao.getAllYMCAResults();
    }

    @Override
    public List<YMCA> getYMCAResultsForUser(int userId) {
        return ymcaDao.getYMCAResultsForUser(userId);
    }
}