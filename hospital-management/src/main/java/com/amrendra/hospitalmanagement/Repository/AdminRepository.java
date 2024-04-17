package com.amrendra.hospitalmanagement.Repository;

import com.amrendra.hospitalmanagement.Entity.Admin;
import com.amrendra.hospitalmanagement.Request.AdminRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByEmail(String email);
}
