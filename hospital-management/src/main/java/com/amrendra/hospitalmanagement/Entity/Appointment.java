package com.amrendra.hospitalmanagement.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private Date appointmentDate;
    private int appointmentSlots;

    private boolean treatment;
    private boolean doctorFree;

    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;

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

  public boolean isTreatment() {
    return treatment;
  }

  public void setTreatment(boolean treatment) {
    this.treatment = treatment;
  }

  public boolean isDoctorFree() {
    return doctorFree;
  }

  public void setDoctorFree(boolean doctorFree) {
    this.doctorFree = doctorFree;
  }

  public Date getAppointmentDate() {
    return appointmentDate;
  }

  public void setAppointmentDate(Date appointmentDate) {
    this.appointmentDate = appointmentDate;
  }

  public int getAppointmentSlots() {
    return appointmentSlots;
  }

  public void setAppointmentSlots(int appointmentSlots) {
    this.appointmentSlots = appointmentSlots;
  }

}
