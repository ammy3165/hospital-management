package com.amrendra.hospitalmanagement.Repository;

import com.amrendra.hospitalmanagement.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long> {

}
