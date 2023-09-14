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

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String users(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        model.addAttribute("titlePage", "USERS");
        model.addAttribute("users", userService.findAll());
        return "dashboard/users";
    }

    @GetMapping("/users/create")
    public String usersCreate(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        model.addAttribute("titlePage", "USERS CREATE");
        model.addAttribute("user", new User());
        return "dashboard/users-create";
    }

    @PostMapping("/users/create")
    public String usersCreateSubmit(HttpSession session, @ModelAttribute(value = "user") User user) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String userEdit(Model model, HttpSession session, @PathVariable("id") int id) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        model.addAttribute("titlePage", "USERS EDIT");
        model.addAttribute("user", userService.findById(id));
        return "dashboard/users-edit";
    }

    @PostMapping("/users/edit")
    public String usersEditSubmit(HttpSession session, @ModelAttribute(value = "user") User user) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String usersDeleteSubmit(HttpSession session, @PathVariable("id") int id) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        userService.deleteById(id);
        return "redirect:/users";
    }
}
