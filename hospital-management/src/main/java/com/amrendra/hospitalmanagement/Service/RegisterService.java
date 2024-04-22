package com.amrendra.hospitalmanagement.Service;

import com.amrendra.hospitalmanagement.Entity.Admin;

import com.amrendra.hospitalmanagement.Entity.Doctor;
import com.amrendra.hospitalmanagement.Entity.Patient;
import com.amrendra.hospitalmanagement.Entity.Receptionist;
import com.amrendra.hospitalmanagement.Repository.AdminRepository;
import com.amrendra.hospitalmanagement.Repository.DoctorRepository;
import com.amrendra.hospitalmanagement.Repository.PatientRepository;
import com.amrendra.hospitalmanagement.Repository.ReceptionistRepository;
import com.amrendra.hospitalmanagement.Request.PatientRequest;
import com.amrendra.hospitalmanagement.Request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
public class RegisterService {

    private static final String adminName="admin";
    private static final String doctorName="doctor";
    private static final String patientName="patient";
    private static final String receptionistName="receptionist";

    @Autowired
    private AdminRepository adminRepo;
    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private ReceptionistRepository receptionistRepo;

    public void registerStaff(RegisterRequest registerRequest) {

        if (registerRequest.getRole().equalsIgnoreCase(RegisterService.adminName)) {
            Admin admin=new Admin();
            admin.setFirstName(registerRequest.getFirstName());
            admin.setLastName(registerRequest.getLastName());
            admin.setEmail(registerRequest.getEmail());
            admin.setPhoneNumber(registerRequest.getPhoneNumber());
            admin.setPassword(registerRequest.getPassword());
            adminRepo.save(admin);
        } else
         if (registerRequest.getRole().equalsIgnoreCase(RegisterService.doctorName)) {
             Doctor doctor=new Doctor();
            doctor.setFirstName(registerRequest.getFirstName());
            doctor.setLastName(registerRequest.getLastName());
            doctor.setAge(registerRequest.getAge());
            doctor.setEmail(registerRequest.getEmail());
            doctor.setPhoneNumber(registerRequest.getPhoneNumber());
            doctor.setPassword(registerRequest.getPassword());
            doctor.setGender(registerRequest.getGender());
            doctor.setSpecialisation(registerRequest.getSpecialisation());
            doctor.setDoctorPresent(true);
            doctorRepo.save(doctor);

        } else
        if (registerRequest.getRole().equalsIgnoreCase(RegisterService.patientName)) {
            Patient patient=new Patient();
            patient.setFirstName(registerRequest.getFirstName());
            patient.setLastName(registerRequest.getLastName());
            patient.setEmail(registerRequest.getEmail());
            patient.setAge(registerRequest.getAge());
            patient.setGender(registerRequest.getGender());
            patient.setPhone(registerRequest.getPhoneNumber());
            patient.setPassword(registerRequest.getPassword());
            patient.setAddress(registerRequest.getAddress());
            patientRepo.save(patient);

        } else
        if (registerRequest.getRole().equalsIgnoreCase(RegisterService.receptionistName)) {
            Receptionist receptionist=new Receptionist();
            receptionist.setFirstName(registerRequest.getFirstName());
            receptionist.setLastName(registerRequest.getLastName());
            receptionist.setEmail(registerRequest.getEmail());
            receptionist.setGender(registerRequest.getGender());
            receptionist.setPhoneNumber(registerRequest.getPhoneNumber());
            receptionist.setPassword(registerRequest.getPassword());
            receptionistRepo.save(receptionist);

        }
    }

    public void addAllPatient(PatientRequest patientRequest) {
        Patient patient=new Patient();
        patient.setFirstName(patientRequest.getFirstName());
        patient.setLastName(patientRequest.getLastName());
        patient.setGender(patientRequest.getGender());
        patient.setAddress(patientRequest.getAddress());
        patient.setAge(patientRequest.getAge());
        patient.setPhone(patientRequest.getPhoneNumber());
        patient.setPassword(patientRequest.getPassword());
        patient.setEmail(patientRequest.getEmail());
        patientRepo.save(patient);

    }

}
