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

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public String members(Model model) {
        model.addAttribute("titlePage", "MEMBERS");
        model.addAttribute("members", memberService.findAll());
        return "dashboard/members";
    }

    @GetMapping("/members/create")
    public String membersCreate(Model model) {
        model.addAttribute("titlePage", "MEMBERS CREATE");
        model.addAttribute("member", new Member());
        return "dashboard/members-create";
    }

    @PostMapping("/members/create")
    public String membersCreateSubmit(@ModelAttribute(value = "member") Member member) {
        memberService.save(member);
        return "redirect:/members";
    }

    @GetMapping("/members/edit")
    public String membersEdit(Model model) {
        model.addAttribute("titlePage", "MEMBERS EDIT");
        return "dashboard/members-edit";
    }

    @GetMapping("/members/delete/{id}")
    public String membersDeleteSubmit(@PathVariable("id") int id) {
        memberService.deleteById(id);
        return "redirect:/members";
    }
}
