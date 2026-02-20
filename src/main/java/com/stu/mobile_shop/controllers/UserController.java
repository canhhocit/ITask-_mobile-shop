package com.stu.mobile_shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stu.mobile_shop.domains.User;
import com.stu.mobile_shop.services.UserService;

import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String value=userService.handleHello();
        model.addAttribute("canh", value);
        model.addAttribute("canh2", "hay quaaaa");
        return "hello";
    }
    //show view page
    @RequestMapping("/admin/user")
    public String getUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    //sent data
     @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User user){
        System.out.println("RUN HERE: "+ user);
        return "hello";
    }
}
