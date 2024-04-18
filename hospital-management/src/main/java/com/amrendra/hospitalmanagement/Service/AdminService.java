package com.amrendra.hospitalmanagement.Service;

import com.amrendra.hospitalmanagement.Entity.Admin;
import com.amrendra.hospitalmanagement.Entity.Doctor;
import com.amrendra.hospitalmanagement.Entity.Patient;
import com.amrendra.hospitalmanagement.Entity.Receptionist;
import com.amrendra.hospitalmanagement.Exception.ValidationException;
import com.amrendra.hospitalmanagement.Repository.AdminRepository;
import com.amrendra.hospitalmanagement.Repository.DoctorRepository;
import com.amrendra.hospitalmanagement.Repository.PatientRepository;
import com.amrendra.hospitalmanagement.Repository.ReceptionistRepository;
import com.amrendra.hospitalmanagement.Request.AdminRequest;
import com.amrendra.hospitalmanagement.Response.AdminResponse;
import com.amrendra.hospitalmanagement.Response.DoctorResponse;
import com.amrendra.hospitalmanagement.Response.PatientResponse;
import com.amrendra.hospitalmanagement.Response.ReceptionistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;
    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private ReceptionistRepository receptionistRepo;

    public AdminResponse adminLogIn(AdminRequest adminRequest) throws ValidationException {
        Admin admin;
        AdminResponse adminResponse=new AdminResponse();
        admin=adminRepo.findByEmail(adminRequest.getEmail());

        if(admin!=null){
            if(BCrypt.checkpw(adminRequest.getPassword(), admin.getPassword())){

              adminResponse.setFirstName(admin.getFirstName());
              adminResponse.setLastName(admin.getLastName());
              adminResponse.setEmail(admin.getEmail());
              return adminResponse;
            }
            throw new ValidationException("wrong password");
        }
        throw new ValidationException("User not registered");
    }


    public List<DoctorResponse> getAllDoctors() {
       List<Doctor> doctorList=doctorRepo.findByDoctorPresent(true);
       List<DoctorResponse> doctorResponses=new ArrayList<>();
       for(Doctor doctor:doctorList){
           DoctorResponse doctorResponse = new DoctorResponse();
            doctorResponse.setFirstName(doctor.getFirstName());
            doctorResponse.setLastName(doctor.getLastName());
            doctorResponse.setEmail(doctor.getEmail());
            doctorResponses.add(doctorResponse);
       }
        return doctorResponses;
    }

    public List<PatientResponse> getAllPatient() {
        List<PatientResponse> patientResponses=new ArrayList<>();
        List<Patient> patientList=patientRepo.findAll();
        for(Patient patient:patientList){
         PatientResponse patientResponse=new PatientResponse();
            patientResponse.setFirstName(patient.getFirstName());
            patientResponse.setLastName(patient.getLastName());
            patientResponse.setEmail(patient.getEmail());
            patientResponses.add(patientResponse);
        }
        return patientResponses;
    }
    public List<ReceptionistResponse> getAllReceptionist() {
        List<ReceptionistResponse> receptionistResponses=new ArrayList<>();
        List<Receptionist> ReceptionsitList=receptionistRepo.findAll();
        for(Receptionist receptionist:ReceptionsitList){
          ReceptionistResponse receptionistResponse=new ReceptionistResponse();
            receptionistResponse.setFirstName(receptionist.getFirstName());
            receptionistResponse.setLastName(receptionist.getLastName());
            receptionistResponse.setEmail(receptionist.getEmail());
            receptionistResponses.add(receptionistResponse);
        }
        return receptionistResponses;
    }


    public String removeDoctor(String email) throws ValidationException {
        Doctor doctor = doctorRepo.findByEmail(email);
        if (doctor != null) {
            doctorRepo.delete(doctor);
        }
        else {
            throw new ValidationException("No doctor with the specified email");
        }

        return "doctor removed";
    }
}
