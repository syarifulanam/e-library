package com.anam.elibrary.controller;

import com.anam.elibrary.dto.LoginDTO;
import com.anam.elibrary.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("titlePage", "LOGIN");
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping("login")
    public String loginSubmit(@ModelAttribute(value = "login") LoginDTO loginDTO, RedirectAttributes redirectAttributes,
                              HttpServletRequest httpServletRequest) {
        System.out.println(loginDTO.getUsername());
        System.out.println(loginDTO.getPassword());
        if (loginDTO.getUsername().equals("anam") && loginDTO.getPassword().equals("123456")) {
            System.out.println("LOGIN SUKSES");
            //httpServletRequest.setAttribute("IS_LOGIN", "TRUE"); // IS_LOGIN = TRUE maksudnya sukses login
            return "redirect:/dashboard";
        } else {
            redirectAttributes.addFlashAttribute("msgError", "WRONG USERNAME or PASSWORD");
            System.out.println("LOGIN GAGAL");
        }
        return "redirect:/login";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest httpServletRequest) {
        //httpServletRequest.removeAttribute("IS_LOGIN");
        return "redirect:/login";
    }
}
