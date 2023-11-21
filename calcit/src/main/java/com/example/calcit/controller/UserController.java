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
    public String showLoginPage(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/login/loginUser")
    public ModelAndView checksLogin(@ModelAttribute("user") User user) {
        if (userService.checkLogin(user.getEmail(), user.getPassword())) {
            return new ModelAndView("redirect:/");
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            modelAndView.addObject("error", "Invalid email or password");
            return modelAndView;
        }
    }
    @GetMapping(value = "/registration/save")
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
	    userService.saveOrUpdate(user);
	    return new ModelAndView("redirect:/");
	}
}
