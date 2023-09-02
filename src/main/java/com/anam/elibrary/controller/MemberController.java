package com.anam.elibrary.controller;

import com.anam.elibrary.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "dashboard/members-create";
    }

    @GetMapping("/members/edit")
    public String membersEdit(Model model) {
        model.addAttribute("titlePage", "MEMBERS EDIT");
        return "dashboard/members-edit";
    }
}
