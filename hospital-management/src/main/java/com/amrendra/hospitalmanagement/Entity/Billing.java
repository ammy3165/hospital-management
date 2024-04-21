package com.amrendra.hospitalmanagement.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingId;
    private Date billingDate;
    private Double medicineAmount;
    private Double doctorAmount;
    private Double totalAmount;
    private boolean paymentStatus;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="receptionist_id")
    private Receptionist receptionist;
    @OneToOne
    @JoinColumn(name="prescription_id")
    private Prescription prescription;


    public Long getBillingId() {
        return billingId;
    }

    public void setBillingId(Long billingId) {
        this.billingId = billingId;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public Double getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(Double medicineAmount) {
        this.medicineAmount = medicineAmount;
    }

    public Double getDoctorAmount() {
        return doctorAmount;
    }

    public void setDoctorAmount(Double doctorAmount) {
        this.doctorAmount = doctorAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}

