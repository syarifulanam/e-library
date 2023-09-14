package com.anam.elibrary.controller;

import com.anam.elibrary.entity.Book;
import com.anam.elibrary.service.BookService;
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
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String books(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        List<Book> books = bookService.findAll();
        model.addAttribute("titlePage", "BOOKS");
        model.addAttribute("books", books);
        return "dashboard/books";
    }

    @GetMapping("/books/create")
    public String booksCreate(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        model.addAttribute("titlePage", "BOOKS CREATE");
        model.addAttribute("book", new Book());
        return "dashboard/books-create";
    }

    @PostMapping("/books/create")
    public String booksCreateSubmit(HttpSession session, @ModelAttribute(value = "book") Book book) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String booksEdit(Model model, HttpSession session, @PathVariable("id") int id) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        /*Book book = new Book();
        book.setId(12344);
        book.setTitle("APA AJA BOLEH");*/

        /* = bookService.findById(id);
        model.addAttribute("titlePage", "BOOKS EDIT");
        model.addAttribute("book", book);
        return "dashboard/books-edit";*/

        model.addAttribute("titlePage", "BOOKS EDIT");
        model.addAttribute("book", bookService.findById(id));
        return "dashboard/books-edit";
    }

    @PostMapping("/books/edit")
    public String booksEditSubmit(HttpSession session, @ModelAttribute(value = "book") Book book) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        bookService.update(book);
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String booksDeleteSubmit(HttpSession session, @PathVariable("id") int id) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        bookService.deleteById(id);
        return "redirect:/books";
    }
}
