package ma.xproce.blood_donation.services;

import ma.xproce.blood_donation.dao.entities.Appointment;
import ma.xproce.blood_donation.dao.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements AppointmentManager {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment addAppointment(Appointment appointment) {
        try {
            return appointmentRepository.save(appointment);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }


    @Override
    public boolean deleteAppointment(Appointment appointment) {
        appointmentRepository.delete(appointment);
        return true;
    }

    @Override
    public boolean deleteAppointmentById(Integer id) {
        appointmentRepository.deleteById(id);
        return true;
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Integer id) {

        return appointmentRepository.findById(id).orElse(null);
    }
}
