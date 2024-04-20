package com.amrendra.hospitalmanagement.Repository;

import com.amrendra.hospitalmanagement.Entity.Medicine;
import com.amrendra.hospitalmanagement.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
