package ma.xproce.blood_donation.web;

import ma.xproce.blood_donation.dao.entities.Donateur;
/*import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    // Méthode pour afficher la page d'accueil
    @GetMapping("/home")
    public String homePage(Model model) {
        // Ajouter des informations statiques sur le don de sang et son importance
        String introduction = "Bienvenue sur notre site de don de sang. Nous sommes dédiés à sauver des vies en collectant des dons de sang.";
        String importance = "Le don de sang est crucial pour aider les personnes dans le besoin, que ce soit pour des accidents, des interventions chirurgicales, ou des maladies graves.";

        // Ajouter les informations au modèle pour les afficher dans la vue
        model.addAttribute("introduction", introduction);
        model.addAttribute("importance", importance);

        // Si l'utilisateur est connecté, ajouter ses informations
        Donateur donateur = (Donateur) model.getAttribute("donateur");
        if (donateur != null) {
            model.addAttribute("userMessage", "Bonjour " + donateur.getPrenom() + " " + donateur.getNom() + ", merci pour votre engagement !");
        }

        return "html/home";



    }

    @PostMapping("/check-eligibility")
    public String checkEligibility(@RequestParam("age") String age,
                                   @RequestParam("weight") String weight,
                                   @RequestParam("surgery") String surgery,
                                   @RequestParam("disease") String disease,
                                   @RequestParam("tattoos") String tattoos,
                                   @RequestParam("fever") String fever,
                                   Model model) {
        // Effectuer une logique pour déterminer si le donateur est éligible ou non
        boolean isEligible = isDonorEligible(age, weight, surgery, disease, tattoos, fever);

        // Ajouter le résultat au modèle pour l'afficher dans la vue
        model.addAttribute("isEligible", isEligible);

        // Ajouter un message approprié au modèle
        String message = isEligible ? "Vous pouvez donner du sang." : "Vous ne pouvez pas donner du sang.";
        model.addAttribute("message", message);


        // Renvoyer le nom de la vue de résultat
        return "html/home";
    }

    private boolean isDonorEligible(String age, String weight, String surgery, String disease, String tattoos,String fever) {
        // Logique pour déterminer l'éligibilité du donateur en fonction des réponses aux questions
        // Vous pouvez ajouter ici la logique spécifique en fonction des réponses aux questions
        // Par exemple, vérifier si toutes les réponses sont "oui" pour l'éligibilité, sinon renvoyer false
        return age.equalsIgnoreCase("oui") && weight.equalsIgnoreCase("oui") && surgery.equalsIgnoreCase("non") && disease.equalsIgnoreCase("non") && tattoos.equalsIgnoreCase("non") && fever.equalsIgnoreCase("non");
    }
}



 /* // Ajouter les questions du quiz
        List<String> questions = Arrays.asList(
                "Avez-vous plus de 18 ans ?",
                "Pesez-vous au moins 50 kg ?",
                "Avez-vous eu une intervention chirurgicale au cours des 6 derniers mois ?",
                "Avez-vous été diagnostiqué avec une maladie transmissible par le sang ?",
                "Avez-vous eu des tatouages ou des piercings au cours des 12 derniers mois ?",

                "Avez-vous eu de la fièvre au cours des 2 semaines précédentes ?"
        );*/
// model.addAttribute("questions", questions);
// Afficher la page d'accueil*/


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "html/home"; // Nom de la vue Thymeleaf associée à la page d'accueil
    }



}
