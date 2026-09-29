package com.servicelog.model;

public class Appointment {
    private int id;
    private String customerName;
    private String serviceType;
    private String date;
    private String time;
    private String status;

    public Appointment(int id, String customerName, String serviceType,
                       String date, String time, String status) {
        this.id = id;
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Customer: %s | Service: %s | Date: %s | Time: %s | Status: %s",
            id, customerName, serviceType, date, time, status
        );
    }
}
