/*package ma.xproce.blood_donation.web;

import ma.xproce.blood_donation.dao.entities.Appointment;
import ma.xproce.blood_donation.dao.entities.DonationCenter;
import ma.xproce.blood_donation.dao.entities.Donateur;
import ma.xproce.blood_donation.services.AppointmentManager;
import ma.xproce.blood_donation.services.DonationCenterManager;
import ma.xproce.blood_donation.services.DonateurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentManager appointmentManager;

    @Autowired
    private DonationCenterManager donationCenterManager;

    @Autowired
    private DonateurManager donateurManager;

    @GetMapping("/list")
    public String listAppointments(Model model) {
        List<Appointment> appointment = appointmentManager.getAllAppointments();
        model.addAttribute("appointment", appointment);
        return "html/appointments/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<DonationCenter> centre = donationCenterManager.getAllDonationCenters();
        List<Donateur> donateur = donateurManager.getAllDonateurs();

        model.addAttribute("appointment", new Appointment());
        model.addAttribute("centre", centre);
        model.addAttribute("donateur", donateur);

        return "html/appointments/add";
    }

    @PostMapping("/add")
    public String addAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentManager.addAppointment(appointment);
        return "redirect:/html/appointments/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Appointment appointment = appointmentManager.getAppointmentById(id);
        List<DonationCenter> centre = donationCenterManager.getAllDonationCenters();
        List<Donateur> donateur = donateurManager.getAllDonateurs();

        model.addAttribute("appointment", appointment);
        model.addAttribute("centre", centre);
        model.addAttribute("donateur", donateur);

        return "html/appointments/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateAppointment(@PathVariable("id") Integer id, @ModelAttribute("appointment") Appointment appointment) {
        appointment.setId(id);
        appointmentManager.updateAppointment(appointment);
        return "redirect:/html/appointments/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable("id") Integer id) {
        appointmentManager.deleteAppointmentById(id);
        return "redirect:/html/appointments/list";
    }
}*/

package ma.xproce.blood_donation.web;

import ma.xproce.blood_donation.dao.entities.Appointment;
import ma.xproce.blood_donation.dao.entities.DonationCenter;
import ma.xproce.blood_donation.dao.entities.Donateur;
import ma.xproce.blood_donation.services.AppointmentManager;
import ma.xproce.blood_donation.services.DonationCenterManager;
import ma.xproce.blood_donation.services.DonateurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentManager appointmentManager;

    @Autowired
    private DonationCenterManager donationCenterManager;

    @Autowired
    private DonateurManager donateurManager;

    @GetMapping("/list")
    public String listAppointments(Model model) {
        List<Appointment> appointments = appointmentManager.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "html/appointments/list";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<DonationCenter> centers = donationCenterManager.getAllDonationCenters();
        List<Donateur> donateurs = donateurManager.getAllDonateurs();

        model.addAttribute("appointment", new Appointment());
        model.addAttribute("centers", centers);
        model.addAttribute("donateurs", donateurs);

        return "html/appointments/add";
    }

    @PostMapping("/add")
    public String addAppointment(@ModelAttribute("appointment") Appointment appointment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<DonationCenter> centers = donationCenterManager.getAllDonationCenters();
            List<Donateur> donateurs = donateurManager.getAllDonateurs();
            model.addAttribute("centers", centers);
            model.addAttribute("donateurs", donateurs);
            return "html/appointments/add";
        }
        appointmentManager.addAppointment(appointment);
        return "redirect:/appointments/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Appointment appointment = appointmentManager.getAppointmentById(id);
        List<DonationCenter> centers = donationCenterManager.getAllDonationCenters();
        List<Donateur> donateurs = donateurManager.getAllDonateurs();

        model.addAttribute("appointment", appointment);
        model.addAttribute("centers", centers);
        model.addAttribute("donateurs", donateurs);

        return "html/appointments/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateAppointment(@PathVariable("id") Integer id, @ModelAttribute("appointment") Appointment appointment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<DonationCenter> centers = donationCenterManager.getAllDonationCenters();
            List<Donateur> donateurs = donateurManager.getAllDonateurs();
            model.addAttribute("centers", centers);
            model.addAttribute("donateurs", donateurs);
            return "html/appointments/edit";
        }
        appointment.setId(id);
        appointmentManager.updateAppointment(appointment);
        return "redirect:/appointments/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable("id") Integer id) {
        appointmentManager.deleteAppointmentById(id);
        return "redirect:/appointments/list";
    }
}
