package ma.xproce.blood_donation.web;

import ma.xproce.blood_donation.dao.entities.Donateur;
import ma.xproce.blood_donation.services.DonateurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donateurs")
public class DonateurController {
    @Autowired
    private DonateurManager donateurManager;

    @GetMapping("/list")
    public String listDonateurs(Model model) {
        List<Donateur> donateurs = donateurManager.getAllDonateurs();
        model.addAttribute("donateurs", donateurs);
        return "html/donateurs/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("donateur", new Donateur());
        return "html/donateurs/add";
    }

    @PostMapping("/add")
    public String addDonateur(@ModelAttribute("donateur") Donateur donateur) {
        donateurManager.addDonateur(donateur);
        return "redirect:/donateurs/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Donateur donateur = donateurManager.getDonateurById(id);
        model.addAttribute("donateur", donateur);
        return "html/donateurs/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDonateur(@PathVariable("id") Integer id, @ModelAttribute("donateur") Donateur donateur) {
        donateur.setId(id);
        donateurManager.updateDonateur(donateur);
        return "redirect:/donateurs/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteDonateur(@PathVariable("id") Integer id) {
        donateurManager.deleteDonateurById(id);
        return "redirect:/donateurs/list";
    }
}