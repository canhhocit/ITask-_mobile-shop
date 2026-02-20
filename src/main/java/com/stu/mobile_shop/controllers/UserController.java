package com.stu.mobile_shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
