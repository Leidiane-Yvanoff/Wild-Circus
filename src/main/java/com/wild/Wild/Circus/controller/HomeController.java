package com.wild.Wild.Circus.controller;

import com.wild.Wild.Circus.entity.Spectacle;
import com.wild.Wild.Circus.repository.ArtisteRepository;
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
    @Autowired
    private ArtisteRepository artisteRepository;

    //Méthode qui controle la vue pour la page d'accueil
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("artistes", artisteRepository.findTop3ByOrderByName());
        model.addAttribute("spectacles", spectacleRepository.findTop3ByOrderByName());
        return "home";
    }

    @GetMapping("/spectacles")
    public String showSpectacles(Model model) {
        model.addAttribute("artistes", artisteRepository.findAll());
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
        model.addAttribute("artistes", artisteRepository.findAll());
        model.addAttribute("spectacle", spectacleRepository.getOne(id));
        return "spectacle";
    }

    @GetMapping("/artistes")
    public String showArtistes(Model model) {
        model.addAttribute("artistes", artisteRepository.findAll());
        model.addAttribute("spectacles", spectacleRepository.findAll());
        return "show_artistes";
    }

    /**
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/artiste")
    public String showArtiste(Model model, @RequestParam Long id) {
        model.addAttribute("artiste", artisteRepository.getOne(id));
        model.addAttribute("spectacles", spectacleRepository.findAll());
        return "artiste";
    }


    @GetMapping("/error")
    public String error404() {

        return "error";
    }


    @GetMapping("/search")
    public String getBySearch(Model model, @RequestParam  String ville){

        model.addAttribute("spectacles", spectacleRepository.findByVille(ville));
        return "search_spectacles";
    }



}
