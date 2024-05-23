package ma.xproce.blood_donation.services;

import ma.xproce.blood_donation.dao.entities.DonationCenter;

import java.util.List;

public interface DonationCenterManager {
    DonationCenter addDonationCenter(DonationCenter center);
    boolean deleteDonationCenter(DonationCenter center);
    boolean deleteDonationCenterById(Integer id);
    DonationCenter updateDonationCenter(DonationCenter center);
    List<DonationCenter> getAllDonationCenters();
    DonationCenter getDonationCenterById(Integer id);
}
