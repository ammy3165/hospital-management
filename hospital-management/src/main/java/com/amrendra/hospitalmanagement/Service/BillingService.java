package com.amrendra.hospitalmanagement.Service;

import com.amrendra.hospitalmanagement.Entity.*;
import com.amrendra.hospitalmanagement.Exception.oneToOneException;
import com.amrendra.hospitalmanagement.Repository.*;
import com.amrendra.hospitalmanagement.Request.BillingRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepo;
    private DoctorRepository doctorRepo;
    private PatientRepository patientRepo;
    private ReceptionistRepository receptionistRepo;
    private prescriptionRepository prescriptionRepo;

    public Double generateBill(BillingRequest billingRequest) throws oneToOneException {
        Doctor doctor = doctorRepo.findByEmail(billingRequest.getDoctorByEmail());
        Patient patient = patientRepo.findByEmail(billingRequest.getPatientByEmail());
        Receptionist receptionist = receptionistRepo.findByEmail(billingRequest.getReceptionistEmail());
        Prescription prescription = prescriptionRepo.findById(billingRequest.getPrescriptionId()).
                orElseThrow(() -> new oneToOneException("A billing record not found with that prescription id:"));

        if (doctor != null && patient != null && receptionist != null &&
                prescription != null && doctor.isDoctorPresent()) {

            Double medicineAmount = prescription.getMedicines().stream()
                    .mapToDouble(Medicine::getPrice).sum();

            Double totalAmount = medicineAmount + billingRequest.getDoctorAmount();

            Billing billing = new Billing();
            billing.setDoctor(doctor);
            billing.setPatient(patient);
            billing.setReceptionist(receptionist);
            billing.setPrescription(prescription);
            billing.setBillingDate(prescription.getPrescriptionDate());

            billing.setPaymentStatus(false);
            billing.setDoctorAmount(billingRequest.getDoctorAmount());
            billing.setMedicineAmount(medicineAmount);
            billing.setTotalAmount(totalAmount);
            billingRepo.save(billing);

            return totalAmount;
        }
        else throw new EntityNotFoundException("Unable to crate billing or Invalid email or prescriptionId.");
    }
}
