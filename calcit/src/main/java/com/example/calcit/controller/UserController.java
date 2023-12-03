package com.example.calcit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.calcit.model.User;
import com.example.calcit.service.UserService;

import jakarta.servlet.http.HttpSession;


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
    public ModelAndView checksLogin(@ModelAttribute("user") User user, HttpSession session) {
        int userid = userService.checkLogin(user.getEmail(), user.getPassword());
        if (userid != -1) {
            session.setAttribute("userid", userid);
            return new ModelAndView("redirect:/navigation");
        } else {
            session.setAttribute("userid", null);
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

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.setAttribute("userid", null);
        return new ModelAndView("redirect:/");
        
    }
}
