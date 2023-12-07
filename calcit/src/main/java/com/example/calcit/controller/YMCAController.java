package com.example.calcit.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.calcit.model.YMCA;
import com.example.calcit.model.YMCAResult;
import com.example.calcit.service.YMCAService;

@Controller
public class YMCAController {

    @Autowired
    private YMCAService ymcaService;

    @GetMapping("/ymca")
    public String calculate(@ModelAttribute("ymcaResult") YMCAResult ymcaResult, @ModelAttribute("lastYmca") YMCA ymca) {
        List<YMCA> ymcas = ymcaService.getAllYMCAResults();
        if (ymcas.size() > 0) {
            YMCA lastYMCA = ymcas.get(ymcas.size() - 1);
            BigDecimal bd = new BigDecimal(lastYMCA.getValue()).setScale(2, RoundingMode.HALF_UP);
            double newNum = bd.doubleValue();
            ymca.setTimestamp(lastYMCA.getTimestamp());
            ymca.setValue(newNum);
        }
        return "ymca";
    }

    @GetMapping("/calculateYMCA")
    public ModelAndView calculateYMCA(@ModelAttribute("ymcaResult") YMCAResult ymcaResult) {
        double ymcaValue = calculateYmcaValue(ymcaResult.getWeight(), ymcaResult.getWaistCircumference(), ymcaResult.getSex());
        String nutritionalStatus = getNutritionalStatusYMCA(ymcaValue);

        BigDecimal bd = new BigDecimal(ymcaValue).setScale(2, RoundingMode.HALF_UP);
        double newNum = bd.doubleValue();

        ymcaResult.setStatus(nutritionalStatus);
        ymcaResult.setValue(newNum);

        ModelAndView mv = new ModelAndView("forward:/ymca");
        mv.addObject("ymcaResultValues", ymcaResult);

        YMCA ymca = new YMCA();
        ymca.setValue(ymcaValue);
        ymca.setUserId(1);
        ymca.setTimestamp(Timestamp.from(Instant.now()));
        ymcaService.saveOrUpdate(ymca);

        return mv;
    }

    private double calculateYmcaValue(double weight, double waistCircumference, String sex) {
        // Zawartość tkanki tłuszczowej (kobiety) = ((1.634 x obwód pasa [cm] – 0.1804 x masa ciała [kg] - 76.76 ) / 2,2 * masa ciała [kg]) x 100
        // Zawartość tkanki tłuszczowej (mężczyźni) = ((1.634 x obwód pasa [cm] – 0.1804 x masa ciała [kg] - 98.42 ) / 2,2 x masa ciała [kg]) x 100

        double factor;
        if ("female".equalsIgnoreCase(sex)) {
            factor = ((1.634 * waistCircumference - 0.1804 * weight - 76.76) / (2.2 * weight)) * 100 ;
        } else if ("male".equalsIgnoreCase(sex)) {
            factor = ((1.634 * waistCircumference - 0.1804 * weight - 98.42) / (2.2 * weight)) * 100 ;
        } else {
            throw new IllegalArgumentException("Invalid gender. Use 'female' or 'male'.");
        }

        return factor;
    }

    private String getNutritionalStatusYMCA(double ymca) {

        double lowRiskThreshold = 8.0;
        double moderateRiskThreshold = 20.0;

        if (ymca < lowRiskThreshold) {
            return "Low risk of abdominal obesity";
        } else if (ymca >= lowRiskThreshold && ymca < moderateRiskThreshold) {
            return "Moderate risk of abdominal obesity";
        } else {
            return "High risk of abdominal obesity";
        }
    }
}