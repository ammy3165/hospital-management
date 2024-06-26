package com.amrendra.hospitalmanagement.Request;


public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String phoneNumber;
    private String address;
    private int age;
    private String Specialisation;
    private boolean doctorPresent;

    //  doctor|patient|admin|receptionist
    private String role;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialisation() {
        return Specialisation;
    }

    public void setSpecialisation(String specialisation) {
        Specialisation = specialisation;
    }

    public boolean isDoctorPresent() {
        return doctorPresent;
    }

    public void setDoctorPresent(boolean doctorPresent) {
        this.doctorPresent = doctorPresent;
    }

    public String getRole() {
        return role;
    }
}
