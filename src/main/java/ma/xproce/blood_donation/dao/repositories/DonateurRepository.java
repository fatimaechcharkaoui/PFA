package ma.xproce.blood_donation.dao.repositories;

import ma.xproce.blood_donation.dao.entities.Donateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DonateurRepository extends JpaRepository<Donateur, Integer> {

}
