package com.anam.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    @GetMapping("dashboard")
    public String dashboard(Model model, HttpServletRequest httpServletRequest) {
//        if (!httpServletRequest.getAttribute("IS_LOGIN").equals("TRUE")) {
//            return "redirect:/login";
//        }
        model.addAttribute("titlePage", "DASHBOARD");
        return "dashboard/dashboard";
    }
}
