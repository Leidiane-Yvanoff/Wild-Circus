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
        model.addAttribute("spectacles", spectacleRepository.findAll());
        return "show_spectacles";
    }

    /**
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/spectacle")
    public String showParty(Model model, @RequestParam Long id) {
        model.addAttribute("spectacle", spectacleRepository.getOne(id));
        return "spectacle";
    }



    @GetMapping("/error")
    public String error404() {

        return "error";
    }


    @GetMapping("/search/ville")
    public String getSpectaclesBySearch(Model model, @RequestParam String ville){
        model.addAttribute("spectacles", spectacleRepository.findByVille(ville));
        return "search_spectacles";
    }

}
