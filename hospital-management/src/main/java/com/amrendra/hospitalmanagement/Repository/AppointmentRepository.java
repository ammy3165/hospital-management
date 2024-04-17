package com.amrendra.hospitalmanagement.Repository;

import com.amrendra.hospitalmanagement.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository <Appointment, Long>{
}
