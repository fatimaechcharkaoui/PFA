package ma.xproce.blood_donation.services;

import ma.xproce.blood_donation.dao.entities.DonationCenter;
import ma.xproce.blood_donation.dao.repositories.DonationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationCenterService implements DonationCenterManager {
    @Autowired
    private DonationCenterRepository donationCenterRepository;

    @Override
    public DonationCenter addDonationCenter(DonationCenter center) {
        try {
            return donationCenterRepository.save(center);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteDonationCenter(DonationCenter center) {
        donationCenterRepository.delete(center);
        return true;
    }

    @Override
    public boolean deleteDonationCenterById(Integer id) {
        donationCenterRepository.deleteById(id);
        return true;
    }

    @Override
    public DonationCenter updateDonationCenter(DonationCenter center) {
        return donationCenterRepository.save(center);
    }

    @Override
    public List<DonationCenter> getAllDonationCenters() {
        return donationCenterRepository.findAll();
    }

    @Override
    public DonationCenter getDonationCenterById(Integer id) {
        return donationCenterRepository.findById(id).orElse(null);
    }

}
