package org.sbet.landon.roomwebapp.controllers;

import org.sbet.landon.roomwebapp.models.Staff;
import org.sbet.landon.roomwebapp.service.StaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffRestController {
    private final StaffService staffService;

    @GetMapping
    public List<Staff> getAllEmployees() {
        return staffService.getAllEmployees();
    }

    public StaffRestController(StaffService staffService) {
        this.staffService = staffService;
    }
}
