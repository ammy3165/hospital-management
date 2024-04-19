package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Request.PatientRequest;
import com.amrendra.hospitalmanagement.Request.RegisterRequest;

import com.amrendra.hospitalmanagement.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/login")
    public String registerStaff(@RequestBody RegisterRequest registerRequest){
         registerService.registerStaff(registerRequest);
         return "staff registered successfully.";
    }
    @PostMapping("/upload/patient")
    public String addPatient(@RequestBody PatientRequest patientRequest){
         registerService.addAllPatient(patientRequest);
        return "All Patients added";
    }
}
