package com.amrendra.hospitalmanagement.Request;

import java.sql.Date;

public class PrescriptionRequest {

   private String givenPrescription;
   private Date prescriptionDate;
   private String patientEmail;
   private String doctorEmail;

   private String medicineName;

   public String getGivenPrescription() {
      return givenPrescription;
   }

   public void setGivenPrescription(String givenPrescription) {
      this.givenPrescription = givenPrescription;
   }

   public Date getPrescriptionDate() {
      return prescriptionDate;
   }

   public void setPrescriptionDate(Date prescriptionDate) {
      this.prescriptionDate = prescriptionDate;
   }

   public String getPatientEmail() {
      return patientEmail;
   }

   public void setPatientEmail(String patientEmail) {
      this.patientEmail = patientEmail;
   }

   public String getDoctorEmail() {
      return doctorEmail;
   }

   public void setDoctorEmail(String doctorEmail) {
      this.doctorEmail = doctorEmail;
   }

   public String getMedicineName() {
      return medicineName;
   }

   public void setMedicineName(String medicineName) {
      this.medicineName = medicineName;
   }
}
