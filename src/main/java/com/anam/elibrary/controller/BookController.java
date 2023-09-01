package com.anam.elibrary.controller;

import com.anam.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("titlePage", "BOOKS");
        model.addAttribute("books", bookService.findAll());
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
