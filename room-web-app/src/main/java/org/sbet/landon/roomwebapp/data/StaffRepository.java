package org.sbet.landon.roomwebapp.data;

import org.sbet.landon.roomwebapp.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
