package com.stu.mobile_shop.controllers;

import java.util.List;

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
        List<User> arrUsers = userService.getAllUsers();
        System.out.println(arrUsers);
        model.addAttribute("canh2", "hay quaaaa");
        return "hello";
    }

    // show table users
    @RequestMapping("/admin/user") //url
    public String getUserPage(Model model) {
        List<User> arrusers = userService.getAllUsers();
        model.addAttribute("users", arrusers);
        return "admin/user/table-user";//file
    }

    // show create view page
    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // sent data
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
        userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }
}
