package ma.xproce.blood_donation.dao.repositories;

import ma.xproce.blood_donation.dao.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
