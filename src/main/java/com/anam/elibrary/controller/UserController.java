package com.anam.elibrary.controller;

import com.anam.elibrary.entity.User;
import com.anam.elibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("titlePage", "SYSTEM USERS");
        model.addAttribute("users", userService.findAll());
        return "dashboard/users";
    }

    @GetMapping("/users/create")
    public String systemUsersCreate(Model model) {
        model.addAttribute("titlePage", "SYSTEM USERS CREATE");
        model.addAttribute("user", new User());
        return "dashboard/users-create";
    }

    @PostMapping("/users/create")
    public String systemUsersCreateSubmit(@ModelAttribute(value = "user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String systemUsersEdit(Model model) {
        model.addAttribute("titlePage", "SYSTEM USERS EDIT");
        return "dashboard/users-edit";
    }

    @GetMapping("/users/delete/{id}")
    public String systemUsersDeleteSubmit(@PathVariable("id")int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
