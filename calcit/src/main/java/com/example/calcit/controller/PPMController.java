package com.example.calcit.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.example.calcit.model.PPM;
import com.example.calcit.model.PPMResult;
import com.example.calcit.service.PPMService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PPMController {

    @Autowired
    private PPMService ppmService;

    @GetMapping("/ppm")
    public String calculate(@ModelAttribute("ppmResult") PPMResult ppmResult, @ModelAttribute("lastPpm") PPM ppm,
            HttpSession session) {

        if (session.getAttribute("userid") != null) {
            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            List<PPM> ppms = ppmService.getPPMResultsForUser(userid);
            if (ppms.size() > 0) {
                PPM lastPPM = ppms.get(ppms.size() - 1);
                BigDecimal bd = new BigDecimal(lastPPM.getValue()).setScale(2, RoundingMode.HALF_UP);
                double newNum = bd.doubleValue();
                ppm.setTimestamp(lastPPM.getTimestamp());
                ppm.setValue(newNum);
            }
        }
        return "ppm";
    }

    @GetMapping("/calculatePPM")
    public ModelAndView calculatePPM(@ModelAttribute("ppmResult") PPMResult ppmResult, HttpSession session) {
        double ppmValue = calculatePPMValue(ppmResult.getWeight(), ppmResult.getHeight() / 100,
                ppmResult.age);

        BigDecimal bd = new BigDecimal(ppmValue).setScale(2, RoundingMode.HALF_UP);
        double newNum = bd.doubleValue();

        ppmResult.setValue(newNum);

        ModelAndView mv = new ModelAndView("forward:/ppm");
        mv.addObject("ppmResultValues", ppmResult);

        if (session.getAttribute("userid") != null) {
            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            PPM ppm = new PPM();
            ppm.setValue(ppmValue);
            ppm.setUserId(userid);
            ppm.setTimestamp(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.MINUTES)));
            ppmService.saveOrUpdate(ppm);
        }

        return mv;
    }

    private double calculatePPMValue(double weight, double height, int age) {
        double ppm = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
        return ppm;
    }
}
