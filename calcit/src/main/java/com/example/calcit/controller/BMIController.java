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
import com.example.calcit.model.BMI;
import com.example.calcit.model.BMIResult;
import com.example.calcit.service.BMIService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BMIController {

    @Autowired
    private BMIService bmiService;

    @GetMapping("/bmi")
    public String calculate(@ModelAttribute("bmiResult") BMIResult bmiResult, @ModelAttribute("lastBmi") BMI bmi,
            HttpSession session) {

        if (session.getAttribute("userid") != null) {
            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            List<BMI> bmis = bmiService.getBMIResultsForUser(userid);
            if (bmis.size() > 0) {
                BMI lastBMI = bmis.get(bmis.size() - 1);
                BigDecimal bd = new BigDecimal(lastBMI.getValue()).setScale(2, RoundingMode.HALF_UP);
                double newNum = bd.doubleValue();
                bmi.setTimestamp(lastBMI.getTimestamp());
                bmi.setValue(newNum);
            }
        }
        return "bmi";
    }

    @GetMapping("/calculateBMI")
    public ModelAndView calculateBMI(@ModelAttribute("bmiResult") BMIResult bmiResult, HttpSession session) {
        double bmiValue = calculateBMIValue(bmiResult.getWeight(), bmiResult.getHeight() / 100);
        String nutritionalStatus = getNutritionalStatus(bmiValue);

        BigDecimal bd = new BigDecimal(bmiValue).setScale(2, RoundingMode.HALF_UP);
        double newNum = bd.doubleValue();

        bmiResult.setStatus(nutritionalStatus);
        bmiResult.setValue(newNum);

        ModelAndView mv = new ModelAndView("forward:/bmi");
        mv.addObject("bmiResultValues", bmiResult);

        if (session.getAttribute("userid") != null) {
            int userid = Integer.parseInt(session.getAttribute("userid").toString());
            BMI bmi = new BMI();
            bmi.setValue(bmiValue);
            bmi.setUserId(userid);
            bmi.setTimestamp(Timestamp.from(Instant.now()));
            bmiService.saveOrUpdate(bmi);
        }

        return mv;
    }

    private double calculateBMIValue(double weight, double height) {

        return (weight / (height * height));
    }

    private String getNutritionalStatus(double bmi) {

        if (bmi < 18.5) {
            return "Warning: You are underweight!";
        } else if (bmi <= 24.9 && bmi >= 18.5) {
            return "Congratulations! Your body weight is correct!";
        } else if (bmi <= 29.9 && bmi > 24.9) {
            return "Warning: You are overweight!";
        } else if (bmi <= 34.9 && bmi > 29.9) {
            return "Warning: You have stage I obesity. Currently, obesity is considered a disease of civilisation and can have a negative impact on your health. "
                    + "We recommend that you change your lifestyle and eating habits and consult your doctor";
        } else if (bmi <= 39.9 && bmi > 34.9) {
            return "Warning: You have stage II obesity. Currently, obesity is considered a disease of civilisation and can have a negative impact on your health. "
                    + "We recommend that you change your lifestyle and eating habits and consult your doctor";
        } else if (bmi >= 40) {
            return "Warning: You have stage III obesity. Currently, obesity is considered a disease of civilisation and can have a negative impact on your health. "
                    + "We recommend that you change your lifestyle and eating habits and consult your doctor";
        } else {
            return "An incorrect value has been entered!";
        }
    }
}
