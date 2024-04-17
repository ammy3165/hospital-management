package com.amrendra.hospitalmanagement.Request;

public class AppointmentRequest {

    public String doctorEmail;
    private String appointmentDate;
    private int appointmentSlots;

    private String patientEmail;


    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getAppointmentSlots() {
        return appointmentSlots;
    }

    public void setAppointmentSlots(int appointmentSlots) {
        this.appointmentSlots = appointmentSlots;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }
}
