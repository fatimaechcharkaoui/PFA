package ma.xproce.blood_donation;

import ma.xproce.blood_donation.dao.entities.Appointment;
import ma.xproce.blood_donation.dao.entities.Donateur;
import ma.xproce.blood_donation.dao.entities.DonationCenter;
import ma.xproce.blood_donation.dao.repositories.AppointmentRepository;
import ma.xproce.blood_donation.dao.repositories.DonateurRepository;
import ma.xproce.blood_donation.dao.repositories.DonationCenterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication

public class BloodDonationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(AppointmentRepository appointmentRepository, DonateurRepository donateurRepository,
                                   DonationCenterRepository donationCenterRepository) {
        return args -> {
            // Création d'un donateur
            Donateur donateur = new Donateur();
            donateur.setNom("Danane");
            donateur.setPrenom("Hajar");
            donateur.setTel("0623456789");
            donateur.setEmail("hajar.danane@example.com");
            donateur.setPassword("donateur1");
            donateur.setBloodGroup("O+");
            donateurRepository.save(donateur);

            // Création d'un centre de donation
            DonationCenter donationCenter = new DonationCenter();
            donationCenter.setName("CentreDonation");
            donationCenter.setAddress("123 Rue ezzouhour , El jadida");
            donationCenter.setTel("0623455557");

            donationCenterRepository.save(donationCenter);

            // Création d'un rendez-vous
            Appointment appointment = new Appointment();
            appointment.setDate(new Date());
            appointment.setHeure(new Date());
            appointment.setDonateur(donateur);
            appointment.setCenter(donationCenter);

            appointmentRepository.save(appointment);

            // Create another appointment for the next day
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_YEAR, 1);
            Date tomorrow = cal.getTime();

            Appointment appointment2 = new Appointment();
            appointment2.setDate(tomorrow); // Date for the next day
            appointment2.setHeure(new Date()); // Current time
            appointment2.setDonateur(donateur);
            appointment2.setCenter(donationCenter);
            appointmentRepository.save(appointment2);
        };

    }


}


