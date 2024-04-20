package com.amrendra.hospitalmanagement.Service;

import com.amrendra.hospitalmanagement.Entity.Medicine;
import com.amrendra.hospitalmanagement.Repository.MedicineRepository;
import com.amrendra.hospitalmanagement.Request.MedicineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepo;

    public void addMedicine(MedicineRequest medicineRequest) {
       Medicine medicine=new Medicine();
       medicine.setMedicineName(medicineRequest.getMedicineName());
       medicine.setPrice(medicineRequest.getPrice());
       medicineRepo.save(medicine);
    }
}
