package com.anam.elibrary.controller;

import com.anam.elibrary.entity.Book;
import com.anam.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("book", new Book());
        return "dashboard/books-create";
    }

    @PostMapping("/books/create")
    public String booksCreateSubmit(@ModelAttribute(value = "book") Book book) {
        bookService.save(book);
        return "redirect:/books";
    }


    @GetMapping("/books/edit")
    public String booksEdit(Model model) {
        model.addAttribute("titlePage", "BOOKS EDIT");
        return "dashboard/books-edit";
    }
}
