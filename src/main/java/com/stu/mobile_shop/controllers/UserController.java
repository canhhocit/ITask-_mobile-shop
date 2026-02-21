package com.stu.mobile_shop.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stu.mobile_shop.domains.User;
import com.stu.mobile_shop.services.UserService;

import lombok.RequiredArgsConstructor;

// @RestController
@Controller
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // show table users
    @GetMapping // url
    public String getUserPage(Model model) {
        List<User> arrusers = userService.getAllUsers();
        model.addAttribute("users", arrusers);
        return "admin/user/table-user";// file
    }

    // show create view page
    // @RequestMapping("/admin/user/create")
    @GetMapping("/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // sent data
    // @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
        userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    // Detail
    @GetMapping("/{id}")
    public String getUserDetailPage(Model model, @PathVariable Long id) {
        User user = userService.getUserbyID(id);
        model.addAttribute("detailUser", user);
        return "admin/user/detail";
    }

    // update
    @GetMapping("update/{id}")
    public String getUpdatePage(Model model, @PathVariable Long id) {
        User currentUser = userService.getUserbyID(id);
        model.addAttribute("currentUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("currentUser") User user) {
        userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    // delete
    @GetMapping("/delete/{id}")
public String deleteUser(@PathVariable Long id) {
    userService.deleteUserById(id);
    return "redirect:/admin/user";
}

}
