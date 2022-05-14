package com.example.listview_liu;

public class Car {
    private String model;
    private int year,image;
    private double rate;

    public Car(String model, int year, int image, double rate) {
        this.model = model;
        this.year = year;
        this.image = image;
        this.rate = rate;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Model: " + model +
                "\nYear: " + year +
                "\nRate: " + rate +
                '\n';
    }
}
