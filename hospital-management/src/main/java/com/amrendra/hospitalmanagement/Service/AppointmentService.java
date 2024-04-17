package com.amrendra.hospitalmanagement.Service;

import com.amrendra.hospitalmanagement.Entity.Appointment;
import com.amrendra.hospitalmanagement.Entity.Doctor;
import com.amrendra.hospitalmanagement.Entity.Patient;
import com.amrendra.hospitalmanagement.Repository.AppointmentRepository;
import com.amrendra.hospitalmanagement.Repository.DoctorRepository;
import com.amrendra.hospitalmanagement.Repository.PatientRepository;
import com.amrendra.hospitalmanagement.Request.AppointmentRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepo;
    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired
    private PatientRepository patientRepo;


    public void addAppointment(AppointmentRequest appointmentRequest) throws ParseException {
        List<Doctor> doctorList=doctorRepo.findAll();

        Doctor selectedDoctor=doctorList.stream().
          filter(doctor ->appointmentRequest.getDoctorEmail().equals(doctor.getEmail())).
                findFirst().orElseThrow(null);

      if(selectedDoctor!=null){
            Patient patient= patientRepo.findByEmail(appointmentRequest.getPatientEmail());

;           if(patient!=null) {

            }else throw new EntityNotFoundException("Patient not found. Please Register here.");

            if(appointmentRepo.findAll().stream().anyMatch(appointment ->
                    appointment.getDoctor().getDoctorId()==selectedDoctor.getDoctorId()&&
                    appointment.getPatient().getPatientId()==patient.getPatientId())) {

            }else {
                throw new EntityNotFoundException("Appointment already scheduled");
            }

            Appointment appointment=new Appointment();
            appointment.setDoctor(selectedDoctor);
            appointment.setPatient(patient);
            appointment.setTreatment(false);
            appointment.setDoctorFree(true);

          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          Date utilDate = sdf.parse(appointmentRequest.getAppointmentDate());
          java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


           appointment.setAppointmentDate(sqlDate);
           appointment.setAppointmentSlots(appointmentRequest.getAppointmentSlots());

            appointmentRepo.save(appointment);

        }
        else
          {
            throw new EntityNotFoundException("Doctor not found");
          }
    }
}
