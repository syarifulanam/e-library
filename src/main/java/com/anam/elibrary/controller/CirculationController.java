package com.anam.elibrary.controller;

import com.anam.elibrary.service.CirculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CirculationController {

    @Autowired
    private CirculationService circulationService;

    @GetMapping("/circulations")
    public String circulation(Model model) {
        model.addAttribute("titlePage", "CIRCULATIONS");
        model.addAttribute("circulations", circulationService.findAll());
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
