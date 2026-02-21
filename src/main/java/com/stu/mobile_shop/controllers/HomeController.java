package com.stu.mobile_shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
      @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("canh2", "hay quaaaa");
        return "hello";
    }
}
