package com.anam.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemUserController {

    @GetMapping("/system-users")
    public String users(Model model) {
        model.addAttribute("titlePage", "SYSTEM USERS");
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
