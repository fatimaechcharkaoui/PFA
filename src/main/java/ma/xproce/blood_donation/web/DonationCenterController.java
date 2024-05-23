package ma.xproce.blood_donation.web;

import ma.xproce.blood_donation.dao.entities.DonationCenter;
import ma.xproce.blood_donation.services.DonationCenterManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequestMapping("/centres")
public class DonationCenterController {

    @Autowired
    private DonationCenterManager donationCenterManager;

    @GetMapping("/list")
    public String listCentres(Model model) {
        List<DonationCenter> centres = donationCenterManager.getAllDonationCenters();
        model.addAttribute("centres", centres);
        return "html/centres/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("centre", new DonationCenter());
        return "html/centres/add";
    }

    @PostMapping("/add")
    public String addCentre(@ModelAttribute("centre") DonationCenter centre) {
        donationCenterManager.addDonationCenter(centre);
        return "redirect:/centres/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        DonationCenter centre = donationCenterManager.getDonationCenterById(id);
        model.addAttribute("centre", centre);
        return "html/centres/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateCentre(@PathVariable("id") Integer id, @ModelAttribute("centre") DonationCenter centre) {
        centre.setId(id);
        donationCenterManager.updateDonationCenter(centre);
        return "redirect:/centres/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCentre(@PathVariable("id") Integer id) {
        donationCenterManager.deleteDonationCenterById(id);
        return "redirect:/centres/list";
    }

}
