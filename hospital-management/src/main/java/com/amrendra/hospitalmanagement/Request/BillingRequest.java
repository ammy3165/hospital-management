package com.amrendra.hospitalmanagement.Request;

public class BillingRequest {
    private Double DoctorAmount;
    private String DoctorEmail;
    private Long prescriptionId;

    private String DoctorByEmail;
    private String PatientByEmail;
    private String ReceptionistEmail;

    public Double getDoctorAmount() {
        return DoctorAmount;
    }

    public void setDoctorAmount(Double doctorAmount) {
        DoctorAmount = doctorAmount;
    }


    public String getDoctorEmail() {
        return DoctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        DoctorEmail = doctorEmail;
    }



    public String getDoctorByEmail() {
        return DoctorByEmail;
    }

    public void setDoctorByEmail(String doctorByEmail) {
        DoctorByEmail = doctorByEmail;
    }

    public String getPatientByEmail() {
        return PatientByEmail;
    }

    public void setPatientByEmail(String patientByEmail) {
        PatientByEmail = patientByEmail;
    }

    public String getReceptionistEmail() {
        return ReceptionistEmail;
    }

    public void setReceptionistEmail(String receptionistEmail) {
        ReceptionistEmail = receptionistEmail;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
}
