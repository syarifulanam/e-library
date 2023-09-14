package com.anam.elibrary.controller;

import com.anam.elibrary.entity.Book;
import com.anam.elibrary.entity.Member;
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
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public String members(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        model.addAttribute("titlePage", "MEMBERS");
        model.addAttribute("members", memberService.findAll());
        return "dashboard/members";
    }

    @GetMapping("/members/create")
    public String membersCreate(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        model.addAttribute("titlePage", "MEMBERS CREATE");
        model.addAttribute("member", new Member());
        return "dashboard/members-create";
    }

    @PostMapping("/members/create")
    public String membersCreateSubmit(HttpSession session,
                                      @ModelAttribute(value = "member") Member member) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        memberService.save(member);
        return "redirect:/members";
    }

    @GetMapping("/members/edit/{id}")
    public String membersEdit(Model model, HttpSession session, @PathVariable("id") int id) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        model.addAttribute("titlePage", "MEMBERS EDIT");
        model.addAttribute("member", memberService.findById(id));
        return "dashboard/members-edit";
    }

    @PostMapping("/members/edit")
    public String membersEditSubmit(HttpSession session,
                                    @ModelAttribute(value = "member") Member member) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        memberService.update(member);
        return "redirect:/members";
    }

    @GetMapping("/members/delete/{id}")
    public String membersDeleteSubmit(HttpSession session, @PathVariable("id") int id) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        memberService.deleteById(id);
        return "redirect:/members";
    }
}
