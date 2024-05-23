package ma.xproce.blood_donation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    // Afficher le formulaire de contact
    @GetMapping("/contact")
    public String showContactForm() {
        return "html/contact"; // Cela renvoie à un fichier HTML ou JSP nommé contact.html ou contact.jsp
    }

    // Gérer la soumission du formulaire de contact
    @PostMapping("/contact")
    public String handleContactForm(@RequestParam String name, @RequestParam String email, @RequestParam String message, Model model) {
        // Traitement des données du formulaire (par exemple, envoyer un e-mail)


        // Ajouter des attributs au modèle pour afficher un message de confirmation à l'utilisateur
        model.addAttribute("confirmationMessage", "Votre message a été envoyé avec succès. Nous vous contacterons bientôt !");

        return "html/confirmation"; // Renvoie à une page de confirmation
    }
}
