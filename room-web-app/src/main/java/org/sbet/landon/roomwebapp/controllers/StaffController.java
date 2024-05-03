package org.sbet.landon.roomwebapp.controllers;

import org.sbet.landon.roomwebapp.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class StaffController {
    private StaffService staffService;

    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", staffService.getAllEmployees());
        return "employees";
    }

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
}

