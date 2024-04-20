package com.amrendra.hospitalmanagement.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long prescriptionId;
    private Date prescriptionDate;
    private String givenPrescription;

    @OneToOne
    private Appointment appointment;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medicine medicines;


    public java.sql.Date getPrescriptionDate() {
        return (java.sql.Date) prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }


    public String getGivenPrescription() {
        return givenPrescription;
    }

    public void setGivenPrescription(String givenPrescription) {
        this.givenPrescription = givenPrescription;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointmentDate) {
        this.appointment = appointment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(List<Doctor> selectedDoctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public Medicine getMedicine() {
        return (Medicine) medicines;
    }

    public void setMedicine(Medicine medicine) {
        this.medicines = medicines;
    }
}
