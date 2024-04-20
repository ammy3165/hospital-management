package com.amrendra.hospitalmanagement.Request;

public class MedicineRequest {
    private String MedicineName;
    private Float price;

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
