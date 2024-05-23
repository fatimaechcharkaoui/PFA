package ma.xproce.blood_donation.services;



import ma.xproce.blood_donation.dao.entities.Donateur;
import ma.xproce.blood_donation.dao.repositories.DonateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonateurService implements DonateurManager {
    @Autowired
    private DonateurRepository donateurRepository;

    @Override
    public Donateur addDonateur(Donateur donateur) {
        try {
            return donateurRepository.save(donateur);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteDonateur(Donateur donateur) {
        try {
            donateurRepository.delete(donateur);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteDonateurById(Integer id) {
        try {
            donateurRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }


    @Override
    public Donateur updateDonateur(Donateur donateur) {
        try {
            return donateurRepository.save(donateur);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Donateur> getAllDonateurs() {
        return donateurRepository.findAll();
    }

    @Override
    public Donateur getDonateurById(Integer id) {
        return donateurRepository.findById(id).orElse(null);
    }


}
