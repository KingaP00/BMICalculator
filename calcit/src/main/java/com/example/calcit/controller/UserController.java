package com.example.calcit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.calcit.model.User;
import com.example.calcit.service.UserService;


@Controller
public class UserController {

    @Autowired
	private UserService userService;

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping(value = "/registration/save")
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
	    userService.saveOrUpdate(user);
	    return new ModelAndView("redirect:/");
	}
}
