package com.amrendra.hospitalmanagement.Repository;

import com.amrendra.hospitalmanagement.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    Doctor findByEmail(String email);

    List<Doctor> findByDoctorPresent(boolean doctorPresent);
}
