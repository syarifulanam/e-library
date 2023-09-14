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

import javax.servlet.http.HttpSession;
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
    public String circulation(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        List<Circulation> circulations = circulationService.findAll();
        model.addAttribute("titlePage", "CIRCULATIONS");
        model.addAttribute("circulations", circulations);
        return "dashboard/circulations";
    }

    @GetMapping("/circulations/create/request")
    public String circulationCreateRequest(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        model.addAttribute("titlePage", "CIRCULATIONS CREATE REQUEST");
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("members", memberService.findAll());
        model.addAttribute("circulationDTO", new CirculationDTO());
        return "dashboard/circulations-create-request";
    }

    @PostMapping("/circulations/create/request")
    public String circulationCreateRequest(HttpSession session,
                                           @ModelAttribute(value = "circulationDTO") CirculationDTO circulationDTO) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        circulationService.saveBookBorrowingData(circulationDTO);
        return "redirect:/circulations";
    }

    @GetMapping("/circulations/cancel/request/{id}")
    public String circulationEditRequest(HttpSession session, @PathVariable("id") int id) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        circulationService.cancelRequest(id);
        return "redirect:/circulations";
    }

    @GetMapping("/circulations/create/return/{id}")
    public String circulationCreateReturn(Model model, HttpSession session, @PathVariable("id") int id) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        Circulation circulation = circulationService.findById(id);
        model.addAttribute("circulation", circulation);
        model.addAttribute("circulationDTO", new CirculationDTO());
        model.addAttribute("titlePage", "CIRCULATIONS CREATE RETURN");
        return "dashboard/circulations-create-return";
    }

    @PostMapping("/circulations/create/return/{id}")
    public String circulationCreateReturnSubmit(HttpSession session,
                                                @ModelAttribute(value = "circulationDTO") CirculationDTO circulationDTO,
                                                @PathVariable("id") int id) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        circulationService.saveBookReturnData(circulationDTO, id);
        return "redirect:/circulations";
    }
}
