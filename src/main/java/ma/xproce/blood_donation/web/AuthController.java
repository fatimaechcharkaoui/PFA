package ma.xproce.blood_donation.web;


import ma.xproce.blood_donation.services.DonateurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AuthController {

    @Autowired
    private DonateurManager donateurManager;

    @GetMapping("/login")
    public String login() {
        return "html/login";  // Renvoie à la vue login.html
    }



}