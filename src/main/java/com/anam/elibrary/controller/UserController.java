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
        model.addAttribute("titlePage", "USERS");
        model.addAttribute("users", userService.findAll());
        return "dashboard/users";
    }

    @GetMapping("/users/create")
    public String usersCreate(Model model) {
        model.addAttribute("titlePage", "USERS CREATE");
        model.addAttribute("user", new User());
        return "dashboard/users-create";
    }

    @PostMapping("/users/create")
    public String usersCreateSubmit(@ModelAttribute(value = "user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String userEdit(Model model, @PathVariable("id") int id) {
        model.addAttribute("titlePage", "USERS EDIT");
        model.addAttribute("user", userService.findById(id));
        return "dashboard/users-edit";
    }

    @PostMapping("/users/edit")
    public String usersEditSubmit(@ModelAttribute(value = "user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String usersDeleteSubmit(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
