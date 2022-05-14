package com.example.sample_midterm;

public class Car {

    private int Year,ImageId;
    private double RentPerDay;
    private String Model;

    public Car(String model, int year, int imageId, double rentPerDay ) {
        Year = year;
        ImageId = imageId;
        RentPerDay = rentPerDay;
        Model = model;
    }

    public int getYear() {
        return Year;
    }

    public int getImageId() {
        return ImageId;
    }

    public double getRentPerDay() {
        return RentPerDay;
    }

    public String getModel() {
        return Model;
    }

    @Override
    public String toString() {
        return Model + " - " + Year;
    }
}
