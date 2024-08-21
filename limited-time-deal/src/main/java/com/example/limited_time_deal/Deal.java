package com.example.limited_time_deal;

import java.time.LocalDateTime;

public class Deal {

    private Long id;
    private double price;
    private int quantity;
    private int availableQuantity;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Deal(Long id, double price, int quantity, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getAvailableQuantity() {
        return availableQuantity;
    }
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

}
