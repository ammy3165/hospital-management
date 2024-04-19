package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Exception.ValidationException;
import com.amrendra.hospitalmanagement.Request.DoctorRequest;
import com.amrendra.hospitalmanagement.Response.DoctorResponse;
import com.amrendra.hospitalmanagement.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/login")
    public DoctorResponse loginDoctor(@RequestBody DoctorRequest doctorRequest)
                                                     throws ValidationException {
        return doctorService.loginDoctor(doctorRequest);
    }

}
