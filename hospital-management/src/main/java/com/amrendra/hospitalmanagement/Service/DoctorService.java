package com.amrendra.hospitalmanagement.Service;

import com.amrendra.hospitalmanagement.Entity.Doctor;
import com.amrendra.hospitalmanagement.Exception.ValidationException;
import com.amrendra.hospitalmanagement.Repository.DoctorRepository;
import com.amrendra.hospitalmanagement.Request.DoctorRequest;
import com.amrendra.hospitalmanagement.Response.DoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepo;


    public DoctorResponse loginDoctor(DoctorRequest doctorRequest) throws ValidationException {
        Doctor doctor=doctorRepo.findByEmail(doctorRequest.getEmail());

        if(doctor!=null){
            if(BCrypt.checkpw(doctorRequest.getPassword(),doctor.getPassword())) {
                DoctorResponse doctorResponse=new DoctorResponse();

                doctorResponse.setFirstName(doctor.getFirstName());
                doctorResponse.setLastName(doctor.getLastName());
                doctorResponse.setEmail(doctor.getEmail());
                return doctorResponse;
            }throw new ValidationException("Wrong Password");
        }
        throw new ValidationException("Doctor not registered.");
    }
}

