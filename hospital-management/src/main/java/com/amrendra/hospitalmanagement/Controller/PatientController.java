package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Exception.ValidationException;
import com.amrendra.hospitalmanagement.Request.PatientRequest;
import com.amrendra.hospitalmanagement.Response.PatientResponse;
import com.amrendra.hospitalmanagement.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class PatientController {
    @Autowired
    private PatientService patientService;
    
    @PostMapping("/login")
    public PatientResponse patientLogIn(@RequestBody PatientRequest patientRequest)
                                                          throws ValidationException {
        return patientService.patientLogIn(patientRequest);

    }
}
