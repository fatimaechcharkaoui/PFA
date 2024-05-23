package ma.xproce.blood_donation.services;

import ma.xproce.blood_donation.dao.entities.Appointment;

import java.util.List;

public interface AppointmentManager {
    Appointment addAppointment(Appointment appointment);
    boolean deleteAppointment(Appointment appointment);
    boolean deleteAppointmentById(Integer id);
    Appointment updateAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Integer id);
}
