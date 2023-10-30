package com.example.calcit.userController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GetLogin {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";

    }
}
