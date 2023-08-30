package com.anam.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksController {

    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("titlePage", "BOOKS");
        return "dashboard/books";
    }

    @GetMapping("/books/create")
    public String booksCreate(Model model) {
        model.addAttribute("titlePage", "BOOKS CREATE");
        return "dashboard/books-create";
    }

    @GetMapping("/books/edit")
    public String booksEdit(Model model) {
        model.addAttribute("titlePage", "BOOKS EDIT");
        return "dashboard/books-edit";
    }
}
