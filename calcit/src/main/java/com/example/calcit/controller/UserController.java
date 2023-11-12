package com.example.calcit.controller;

import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.calcit.model.User;
import com.example.calcit.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    // private static final Logger logger = Logger
    //         .getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // public ModelAndView addUser(@ModelAttribute("user") User user, BindingResult result) {
    //     Map<String, Object> model = new HashMap<String, Object>();
    //     model.put("index", new User());
    //     return new ModelAndView("index", model);
    // }

    // @RequestMapping(value = "/login", method = RequestMethod.GET)
    // public String login(Map model) {
    //     User user = new User();
    //     model.put("login", user);
    //     return "login";
    // }

    // @RequestMapping(value = "/loginsuccess", method = RequestMethod.POST)
    // public String loginsuccess(@Valid User user, BindingResult result, Map model) {
    //     if (result.hasErrors()) {
    //         return "login";
    //     }

    //     boolean userExists = userService.checkLogin(user.getUserId(), user.getPassword());
    //     if (userExists) {
    //         model.put("user", user);
    //         return "welcome";
    //     } else {
    //         return "login";
    //     }
    // }

    // @RequestMapping(value = "/logout", method = RequestMethod.GET)
    // public String logout(Model model) {
    //     model.addAttribute("title", "Logout");
    //     return "register";
    // }

    // @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    // public ModelAndView saveUser(@ModelAttribute("user") User user) {
    //     userService.saveOrUpdate(user);
    //     return new ModelAndView("redirect:/");
    // }

    // @RequestMapping(value="/", method = RequestMethod.GET)
    // public String getHomePage(){
    //     return "index";
    // }
}
