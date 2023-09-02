package com.anam.elibrary.controller;

import com.anam.elibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/system-users")
    public String users(Model model) {
        model.addAttribute("titlePage", "SYSTEM USERS");
        model.addAttribute("users", userService.findAll());
        return "dashboard/system-users";
    }

    @GetMapping("/system-users/create")
    public String systemUsersCreate(Model model) {
        model.addAttribute("titlePage", "SYSTEM USERS CREATE");
        return "dashboard/system-users-create";
    }

    @GetMapping("/system-users/edit")
    public String systemUsersEdit(Model model) {
        model.addAttribute("titlePage", "SYSTEM USERS EDIT");
        return "dashboard/system-users-edit";
    }
}
