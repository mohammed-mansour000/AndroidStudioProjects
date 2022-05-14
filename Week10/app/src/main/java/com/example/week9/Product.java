package com.example.week9;

public class Product {
    private int pid;
    private String name;
    private int quantity;
    private double price;
    private String category;

    public Product(int pid, String name, int quantity, double price, String category) {
        this.pid = pid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ID: " + pid +
                "\nName: " + name +
                "\nQuantity: " + quantity +
                "\nPrice: " + price +
                "\nCategory: " + category;
    }
}
