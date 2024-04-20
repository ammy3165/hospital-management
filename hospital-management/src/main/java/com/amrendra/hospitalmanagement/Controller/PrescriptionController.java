package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Request.PrescriptionRequest;
import com.amrendra.hospitalmanagement.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/add")
    public String addPrescription(@RequestBody PrescriptionRequest prescriptionRequest){
        prescriptionService.addPrescription(prescriptionRequest);
        return "Prescription added.";
    }

}
