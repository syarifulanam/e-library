package com.anam.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CirculationController {

    @GetMapping("/circulations")
    public String circulation(Model model) {
        model.addAttribute("titlePage", "CIRCULATIONS");
        return "dashboard/circulations";
    }

    @GetMapping("/circulations/create")
    public String circulationCreate(Model model) {
        model.addAttribute("titlePage", "CIRCULATIONS CREATE");
        return "dashboard/circulations-create";
    }

    @GetMapping("/circulations/edit")
    public String circulationEdit(Model model) {
        model.addAttribute("titlePage", "CIRCULATIONS EDIT");
        return "dashboard/circulations-edit";
    }
}
