package com.example.budgetbuddy.model;

import java.util.Date;

public class Transaction {
    private String id;
    private String title;
    private String category;
    private double amount;
    private Date date;
    private int iconResId;

    public Transaction(String title, String category, double amount, Date date, int iconResId) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.iconResId = iconResId;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public int getIconResId() {
        return iconResId;
    }
}