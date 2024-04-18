package com.amrendra.hospitalmanagement.Entity;

import jakarta.persistence.*;

@Table(name="Doctor")
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private boolean doctorPresent;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean isDoctorPresent() {
        return doctorPresent;
    }

    public void setDoctorPresent(boolean doctorPresent) {
        this.doctorPresent = doctorPresent;
    }
}
