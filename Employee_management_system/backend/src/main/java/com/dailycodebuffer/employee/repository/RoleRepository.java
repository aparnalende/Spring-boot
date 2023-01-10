package com.dailycodebuffer.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.employee.model.ERole;
import com.dailycodebuffer.employee.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByName(ERole name);	
}
