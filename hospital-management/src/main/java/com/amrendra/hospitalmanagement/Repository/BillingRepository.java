package com.amrendra.hospitalmanagement.Repository;

import com.amrendra.hospitalmanagement.Entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {

    List<Billing> findByPatientPhone(String patientPhone);

    @Query("select SUM(b.totalAmount) TotalAmountByPatientPhone from Billing b where b.patient.phone=patientPhone")
    Double TotalAmountByPatientPhone(@Param("patientPhone") String patientPhone);

}
