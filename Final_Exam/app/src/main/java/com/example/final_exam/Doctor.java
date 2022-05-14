package com.example.final_exam;

public class Doctor {

private int phone;
private String Name,Region,Specialty;

    public Doctor(int phone, String name, String region, String specialty) {
        this.phone = phone;
        Name = name;
        Region = region;
        Specialty = specialty;
    }

    public int getPhone() {
        return phone;
    }

    public String getName() {
        return Name;
    }

    public String getRegion() {
        return Region;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    @Override
    public String toString() {
        return
                "phone#" + phone +
                "\n  Dr: '" + Name +
                "\n  Region: '" + Region  +
                "\n Specialty: '" + Specialty;
    }
}
