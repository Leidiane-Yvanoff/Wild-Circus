package com.wild.Wild.Circus.controller;

import com.wild.Wild.Circus.entity.Spectacle;
import com.wild.Wild.Circus.repository.SpectacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class AdminController {

    @Autowired
    private SpectacleRepository spectacleRepository;

    @GetMapping("/admin")
    public String getAdmin(Model model) {
        model.addAttribute("annonces", spectacleRepository.findAll());
        return "dashboard";
    }

    /**
     *  Méthode qui permet d'afficher le formulaire pour ajouter un spectacle dans le espace admin
     * @param model
     * @return
     */
    @GetMapping("admin/create/spectacle")
    public String getSpectacleForm(Model model) {

        model.addAttribute("spectacle", new Spectacle());
        return "spectacle_form";
    }

    /**
     * Méthode que renvoie les informations rentrées dans le formulaire
     * @param spectacle
     * @param bindingResult
     * @return
     */
    @PostMapping("admin/create/spectacle")
    public String postAnnonceForm(@Valid Spectacle spectacle, BindingResult bindingResult) {

        spectacleRepository.save(spectacle);

        if(bindingResult.hasErrors()) {
            return "spectacle_form";
        }
        return "redirect:/";

    }
}
