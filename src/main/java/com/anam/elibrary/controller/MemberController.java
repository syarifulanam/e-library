package com.anam.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/members")
    public String members(Model model) {
        model.addAttribute("titlePage", "MEMBERS");
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
