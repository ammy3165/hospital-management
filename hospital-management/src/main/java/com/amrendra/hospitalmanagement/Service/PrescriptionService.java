package com.amrendra.hospitalmanagement.Service;

import com.amrendra.hospitalmanagement.Entity.*;
import com.amrendra.hospitalmanagement.Repository.*;
import com.amrendra.hospitalmanagement.Request.PrescriptionRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Locale.filter;

@Service
public class PrescriptionService {
   @Autowired
   private PrescriptionRepository prescriptionRepo;
   @Autowired
   private MedicineRepository medicineRepo;
   @Autowired
   private PatientRepository patientRepo;
   @Autowired
   private AppointmentRepository appointmentRepo;
   @Autowired
   private DoctorRepository doctorRepo;

   public void addPrescription(PrescriptionRequest prescriptionRequest) {

        Appointment appointment=new Appointment();
        if(appointment !=null) {
            Doctor selectedDoctor=doctorRepo.findByDoctorPresent(true).stream().
                    filter(doctor->prescriptionRequest.getDoctorEmail().equals(doctor.getEmail())).
                    findFirst().orElse(null);
            if (selectedDoctor!= null){
                Patient patient=patientRepo.findByEmail(prescriptionRequest.getPatientEmail());
                if(patient !=null) {
                    List<Medicine> medicineList=medicineRepo.findAll();
                    Medicine selectedMedicine=medicineList.stream()
                        .filter(medicine->prescriptionRequest.getMedicineName().equals(medicine.getMedicineName()))
                        .findFirst().orElse(null);
                   if (selectedMedicine !=null) {
                       Prescription prescription = new Prescription();
                       prescription.setGivenPrescription(prescriptionRequest.getGivenPrescription());
                       prescription.setMedicine(prescription.getMedicine());
                       prescription.setPrescriptionDate(appointment.getAppointmentDate());
                       prescription.setAppointment(appointment);
                       prescription.setDoctor(selectedDoctor);
                       prescription.setPatient(patient);
                       prescriptionRepo.save(prescription);

                   }else throw new EntityNotFoundException("Some or all medicines are not found in the repository.");

                }else throw new EntityNotFoundException("Patient not found. Please Register.");

            } else throw new EntityNotFoundException("Doctor not found");

        }else throw new EntityNotFoundException("Appointment not scheduled");

   }
}