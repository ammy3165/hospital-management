package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Exception.ValidationException;
import com.amrendra.hospitalmanagement.Request.AdminRequest;
import com.amrendra.hospitalmanagement.Response.AdminResponse;
import com.amrendra.hospitalmanagement.Response.DoctorResponse;
import com.amrendra.hospitalmanagement.Response.PatientResponse;
import com.amrendra.hospitalmanagement.Response.ReceptionistResponse;

import com.amrendra.hospitalmanagement.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @PostMapping(value="/login")
    public AdminResponse adminLogIn(@RequestBody AdminRequest adminRequest) throws ValidationException {

       return adminService.adminLogIn(adminRequest);
    }

    @GetMapping("/allDoctors")
    public List<DoctorResponse> getAllDoctors(){
        return adminService.getAllDoctors();

    }

    @GetMapping("/allPatients")
    public List<PatientResponse> getAllPatient(){
        return adminService.getAllPatient();
    }
    @GetMapping("/allReceptionist")
    public List<ReceptionistResponse> getAllReceptionist(){
        return adminService.getAllReceptionist();
    }

    @PutMapping("/remove/allDoctors")
    public String removeAllDoctors(@RequestParam String email) throws ValidationException {
        adminService.removeDoctor(email);
        return "Removed all the doctors successfully";
    }
}