package com.anam.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogdataController {

    @GetMapping("/log-circulations")
    public String logCirculations(Model model) {
        model.addAttribute("titlePage", "LOG CIRCULATIONS");
        return "dashboard/log-circulations";
    }

    @GetMapping("/log-returns")
    public String logReturn(Model model) {
        model.addAttribute("titlePage", "LOG RETURNS");
        return "dashboard/log-returns";
    }
}
