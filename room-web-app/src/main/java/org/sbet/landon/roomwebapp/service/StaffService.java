package org.sbet.landon.roomwebapp.service;

import org.sbet.landon.roomwebapp.data.StaffRepository;
import org.sbet.landon.roomwebapp.models.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllEmployees() {
        return staffRepository.findAll();

    }
}



