package com.amrendra.hospitalmanagement.Repository;

import com.amrendra.hospitalmanagement.Entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Integer> {

    Receptionist findByEmail(String billingRequest);
}
