package com.wild.Wild.Circus.controller;

import com.wild.Wild.Circus.entity.Spectacle;
import com.wild.Wild.Circus.repository.SpectacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SpectacleRepository spectacleRepository;

    //Méthode qui controle la vue pour la page d'accueil
    @GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/spectacles")
    public String showSpectacles(Model model) {

        return "show_spectacles";
    }


    @GetMapping("/error")
    public String error404() {

        return "error";
    }

    @RequestMapping("/search-name")
    public @ResponseBody
    Spectacle searchSpectacle(@RequestParam String name) {
        return spectacleRepository.findOneByName(name);
    }

    @RequestMapping("/search-ville")
    public @ResponseBody
    List<Spectacle> getSpectaclesByVille(@RequestParam String ville) {
        return spectacleRepository.findByVille(ville);
    }


}
