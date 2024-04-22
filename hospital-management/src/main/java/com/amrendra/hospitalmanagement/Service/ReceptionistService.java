package com.amrendra.hospitalmanagement.Service;

import com.amrendra.hospitalmanagement.Entity.Billing;
import com.amrendra.hospitalmanagement.Entity.Patient;
import com.amrendra.hospitalmanagement.Entity.Receptionist;
import com.amrendra.hospitalmanagement.Exception.ValidationException;
import com.amrendra.hospitalmanagement.Repository.BillingRepository;
import com.amrendra.hospitalmanagement.Repository.PatientRepository;
import com.amrendra.hospitalmanagement.Repository.ReceptionistRepository;
import com.amrendra.hospitalmanagement.Request.ReceptionistRequest;
import com.amrendra.hospitalmanagement.Response.ReceptionistResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionistService {
    @Autowired
    private ReceptionistRepository receptionistRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private BillingRepository billingRepo;

    public ReceptionistResponse logInReceptionist(ReceptionistRequest receptionistRequest)
                                                                 throws ValidationException {
        ReceptionistResponse receptionistResponse =new ReceptionistResponse();
        Receptionist receptionist= receptionistRepo.findByEmail(receptionistRequest.getEmail());
        if (receptionist !=null){
            if(BCrypt.checkpw(receptionist.getPassword(),receptionistRequest.getPassword())) {
                receptionistResponse.setFirstName(receptionist.getFirstName());
                receptionistResponse.setLastName(receptionist.getLastName());
                receptionistResponse.setEmail(receptionist.getEmail());
                return receptionistResponse;

            }else throw new ValidationException("Wrong Password.");
        }
        else
            throw new EntityNotFoundException("Receptionist not registered.");
    }


    public Double getBillDetails(String patientPhone) {

       List<Billing> billingList = billingRepo.findByPatientPhone(patientPhone);

        if (!billingList.isEmpty()) {
            for (Billing billing : billingList) {
                if (!billing.isPaymentStatus()) {
                    return billingRepo.TotalAmountByPatientPhone(patientPhone);
                }
                else return 0.00;
            }
        }
        throw new EntityNotFoundException("No such bill exist");
    }

    public String clearDues(String patientPhone) {
        List<Billing> billing = billingRepo.findByPatientPhone(patientPhone);
        if (billing.isEmpty()) {
            throw new EntityNotFoundException("No such billing list.");
        }else
        for (Billing bill : billing) {
            if (!bill.isPaymentStatus())
                bill.isPaymentStatus();
            billingRepo.save(bill);
        }
        return "Dues cleared.";
    }
}
