package com.example.calcit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.calcit.model.BMI;

@Controller
public class BMIController {

    @GetMapping("/calculateBMI")
    public String calculateBMI() {
//        double bmiValue = calculateBMIValue(bmiResult.getWeight(), bmiResult.getHeight());

//        String nutritionalStatus = getNutritionalStatus(bmiValue);
//        model.addAttribute("bmiValue", bmiValue);
//        model.addAttribute("nutritionalStatus", nutritionalStatus);

        return "bmiResult";
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
