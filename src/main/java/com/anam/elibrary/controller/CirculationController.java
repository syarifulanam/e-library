package com.anam.elibrary.controller;

import com.anam.elibrary.dto.CirculationDTO;
import com.anam.elibrary.entity.Circulation;
import com.anam.elibrary.service.BookService;
import com.anam.elibrary.service.CirculationService;
import com.anam.elibrary.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CirculationController {

    @Autowired
    private CirculationService circulationService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/circulations")
    public String circulation(Model model) {
        List<Circulation> circulations = circulationService.findAll();
        model.addAttribute("titlePage", "CIRCULATIONS");
        model.addAttribute("circulations", circulations);
        return "dashboard/circulations";
    }

    @GetMapping("/circulations/create/request")
    public String circulationCreateRequest(Model model) {
        model.addAttribute("titlePage", "CIRCULATIONS CREATE REQUEST");
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("members", memberService.findAll());
        model.addAttribute("circulationDTO", new CirculationDTO());
        return "dashboard/circulations-create-request";
    }

    @PostMapping("/circulations/create/request")
    public String circulationCreateRequest(@ModelAttribute(value = "circulationDTO") CirculationDTO circulationDTO) {
        circulationService.saveBookBorrowingData(circulationDTO);
        return "redirect:/circulations";
    }

    @GetMapping("/circulations/cancel/request/{id}")
    public String circulationEditRequest(@PathVariable("id") int id) {
        circulationService.cancelRequest(id);
        return "redirect:/circulations";
    }

    @GetMapping("/circulations/create/return")
    public String circulationCreateReturn(Model model) {
        model.addAttribute("titlePage", "CIRCULATIONS CREATE RETURN");
        return "dashboard/circulations-create-return";
    }
}
