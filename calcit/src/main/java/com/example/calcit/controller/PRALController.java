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
import org.springframework.web.servlet.ModelAndView;

import com.example.calcit.model.PRAL;
import com.example.calcit.model.PRALResult;
import com.example.calcit.service.PRALService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PRALController {

    @Autowired
    private PRALService pralService;

    @GetMapping("/pral")
    public String calculate(@ModelAttribute("pralResult") PRALResult pralResult, @ModelAttribute("lastPral") PRAL pral,
            HttpSession session) {

        if (session.getAttribute("userid") != null) {
            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            List<PRAL> prals = pralService.getPRALResultsForUser(userid);
            if (prals.size() > 0) {
                PRAL lastPral = prals.get(prals.size() - 1);
                BigDecimal bd = new BigDecimal(lastPral.getValue()).setScale(2, RoundingMode.HALF_UP);
                double newNum = bd.doubleValue();
                pral.setTimestamp(lastPral.getTimestamp());
                pral.setValue(newNum);
            }
        }

        return "pral";
    }

    @GetMapping("/calculatePRAL")
    public ModelAndView calculatePRAL(@ModelAttribute("pralResult") PRALResult pralResult, HttpSession session) {
        double pralValue = calculatePRALValue(pralResult.getProtein(), pralResult.getPhosphorus(),
                pralResult.getPotassium(), pralResult.getMagnesium(), pralResult.getCalcium());
        String nutritionalStatus = getNutritionalStatus(pralValue);

        BigDecimal bd = new BigDecimal(pralValue).setScale(3, RoundingMode.HALF_UP);
        double newNum = bd.doubleValue();

        pralResult.setStatus(nutritionalStatus);
        pralResult.setValue(newNum);

        ModelAndView mv = new ModelAndView("forward:/pral");
        mv.addObject("pralResultValues", pralResult);

        if (session.getAttribute("userid") != null) {
            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            PRAL pral = new PRAL();
            pral.setValue(pralValue);
            pral.setUserId(userid);
            pral.setTimestamp(Timestamp.from(Instant.now()));
            pralService.saveOrUpdate(pral);
        }
        return mv;
    }

    private double calculatePRALValue(double protein, double phosphorus, double potassium, double magnesium,
            double calcium) {
        return (0.49 * protein + 0.037 * phosphorus) - (0.021 * potassium - 0.026 * magnesium - 0.013 * calcium);
    }

    private String getNutritionalStatus(double pral) {
        if (pral < -15.0) {
            return "Very alkaline product";
        } else if (pral >= -15.0 && pral < 0.0) {
            return "Alkaline product";
        } else if (pral >= 0.0 && pral < 15.0) {
            return "Acidifying product";
        } else {
            return "Very Acidifying product";
        }
    }
}