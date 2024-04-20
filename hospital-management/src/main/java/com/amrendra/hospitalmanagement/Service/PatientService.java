package com.amrendra.hospitalmanagement.Service;

import com.amrendra.hospitalmanagement.Entity.Patient;
import com.amrendra.hospitalmanagement.Exception.ValidationException;
import com.amrendra.hospitalmanagement.Repository.PatientRepository;
import com.amrendra.hospitalmanagement.Request.PatientRequest;
import com.amrendra.hospitalmanagement.Response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepo;

    public PatientResponse patientLogIn(PatientRequest patientRequest) throws ValidationException {
        Patient patient=patientRepo.findByEmail(patientRequest.getEmail());
        if(patient !=null){
            if(BCrypt.checkpw(patientRequest.getPassword(), patient.getPassword() ) ){
                PatientResponse patientResponse = new PatientResponse();
                patientResponse.setFirstName(patient.getFirstName());
                patientResponse.setLastName(patient.getLastName());
                patientResponse.setEmail(patient.getEmail());
                return patientResponse;
            }
                throw new ValidationException("Wrong password");
        }
        else throw new ValidationException("Patient not registered.");
    }
}
