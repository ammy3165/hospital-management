package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Request.MedicineRequest;
import com.amrendra.hospitalmanagement.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping("/add/medicine")
    public String addMedicine(@RequestBody MedicineRequest medicineRequest){
        medicineService.addMedicine(medicineRequest);
        return "medicine added.";
    }
}
