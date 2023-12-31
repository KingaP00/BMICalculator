package com.example.calcit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/navigation")
    public String showNavigationPage() {
        return "navigation";
    }
}
