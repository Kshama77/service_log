package com.servicelog.service;

import com.servicelog.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private final List<Appointment> appointments = new ArrayList<>();
    private int nextId = 1;

    public AppointmentService() {
        addAppointment("John Smith", "Oil Change", "10/05/2026", "10:00 AM");
        addAppointment("Maria Garcia", "Brake Inspection", "10/07/2026", "2:00 PM");
    }

    public void addAppointment(String customerName, String serviceType,
                               String date, String time) {
        Appointment appointment = new Appointment(
            nextId++,
            customerName,
            serviceType,
            date,
            time,
            "Scheduled"
        );
        appointments.add(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public List<Appointment> searchByCustomer(String name) {
        List<Appointment> results = new ArrayList<>();

        for (Appointment appointment : appointments) {
            if (appointment.getCustomerName().toLowerCase()
                    .contains(name.toLowerCase())) {
                results.add(appointment);
            }
        }

        return results;
    }

    public boolean updateStatus(int id, String newStatus) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                appointment.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAppointment(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                appointments.remove(appointment);
                return true;
            }
        }
        return false;
    }
}
