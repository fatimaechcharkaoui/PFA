package ma.xproce.blood_donation.dao.repositories;

import ma.xproce.blood_donation.dao.entities.DonationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationCenterRepository extends JpaRepository<DonationCenter, Integer> {
}
