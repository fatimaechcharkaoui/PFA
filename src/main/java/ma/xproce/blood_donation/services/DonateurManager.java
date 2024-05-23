package ma.xproce.blood_donation.services;

import ma.xproce.blood_donation.dao.entities.Donateur;

import java.util.List;

public interface DonateurManager {
    Donateur addDonateur(Donateur donateur);
    boolean deleteDonateur(Donateur donateur);
    boolean deleteDonateurById(Integer id);
    Donateur updateDonateur(Donateur donateur);
    List<Donateur> getAllDonateurs();
    Donateur getDonateurById(Integer id);

}
