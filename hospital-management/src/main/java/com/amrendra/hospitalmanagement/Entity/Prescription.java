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

    @ManyToMany
    private List<Medicine> medicines;


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

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
