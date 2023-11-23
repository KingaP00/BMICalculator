package com.example.calcit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.calcit.model.BMI;
import com.example.calcit.model.BMIResult;
import com.example.calcit.service.BMIService;


@Controller
public class BMIController {

    @Autowired
	private BMIService bmiService;

    @GetMapping("/bmi")
    public String calculate(@ModelAttribute("bmiResult") BMIResult bmiResult) {
        BMIResult bmr = new BMIResult();
        bmr.setValue(bmiResult.getValue());
        bmr.setStatus(bmiResult.getStatus());
        return "bmi";
    }

    @GetMapping("/calculateBMI")
    public ModelAndView calculateBMI(@ModelAttribute("bmiResult") BMIResult bmiResult) {
        double bmiValue = calculateBMIValue(bmiResult.getWeight(), bmiResult.getHeight());
        String nutritionalStatus = getNutritionalStatus(bmiValue);

        bmiResult.setStatus(nutritionalStatus);
        bmiResult.setValue(bmiValue);

        ModelAndView modelAndView = new ModelAndView("redirect:/bmi");
    
        modelAndView.addObject("bmiResult", bmiResult);

        BMI bmi = new BMI();
        bmi.setValue(bmiValue);
        bmi.setUserId(1);
        bmi.setTimestamp("");

        bmiService.saveOrUpdate(bmi);

        return modelAndView;
    }

    private double calculateBMIValue(double weight, double height) {

        return weight / (height * height);
    }

    private String getNutritionalStatus(double bmi) {

        if (bmi < 18.5) {
            return "Uwaga! Masz niedowagę";
        } else if (bmi <= 24.9 && bmi >= 18.5) {
            return "Brawo! Twoja masa ciała jest prawidłowa";
        } else if (bmi <= 29.9 && bmi > 24.9) {
            return "Uwaga! Masz nadwagę";
        } else if (bmi <= 34.9 && bmi > 29.9) {
            return "Uwaga! Masz I stopień otyłości. Aktualnie otyłość uważana jest za chorobę cywilizacyjną i może mieć negatywny wpływ na twoje zdrowie. "
                    + "Zalecamy zmianę stylu życia i nawyków żywieniowych oraz konsultację z lekarzem";
        } else if (bmi <= 39.9 && bmi > 34.9) {
            return "Uwaga! Masz II stopień otyłości. Aktualnie otyłość uważana jest za chorobę cywilizacyjną i może mieć negatywny wpływ na twoje zdrowie. "
                    + "Zalecamy zmianę stylu życia i nawyków żywieniowych oraz konsultację z lekarzem";
        } else if (bmi >= 40) {
            return "Uwaga! Masz III stopień otyłości. Aktualnie otyłość uważana jest za chorobę cywilizacyjną i może mieć negatywny wpływ na twoje zdrowie. "
                    + "Zalecamy zmianę stylu życia i nawyków żywieniowych oraz konsultację z lekarzem";
        } else {
            return "Wprowadzono nieprawidłową wartość.";
        }
    }
}
