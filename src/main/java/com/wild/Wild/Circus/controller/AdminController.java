package com.wild.Wild.Circus.controller;

import com.wild.Wild.Circus.entity.Artiste;
import com.wild.Wild.Circus.entity.Spectacle;
import com.wild.Wild.Circus.repository.ArtisteRepository;
import com.wild.Wild.Circus.repository.SpectacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class AdminController {

    @Autowired
    private SpectacleRepository spectacleRepository;
    @Autowired
    private ArtisteRepository artisteRepository;

    @GetMapping("/admin")
    public String getAdmin(Model model) {
        model.addAttribute("artistes", artisteRepository.findAll());
        model.addAttribute("spectacles", spectacleRepository.findAll());
        return "dashboard";
    }

    /**
     *  Méthode qui permet d'afficher le formulaire pour ajouter un spectacle dans le espace admin
     * @param model
     * @return
     */
    @GetMapping("admin/create/spectacle")
    public String getSpectacleForm(Model model) {
        model.addAttribute("artistes", artisteRepository.findAll());
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
    public String postSpectacleForm(@Valid Spectacle spectacle, BindingResult bindingResult) {

        spectacleRepository.save(spectacle);

        if(bindingResult.hasErrors()) {
            return "spectacle_form";
        }
        return "redirect:/spectacles";

    }

    /**
     * Méthode que affiche le formulaire ainsi que les informations pour la modification
     * d'un show
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/admin/edit/spectacle")
    public String adminEdit(Model model, @RequestParam Long id) {
        Optional<Spectacle> spectacle = spectacleRepository.findById(id);
        if(spectacle.isPresent()) {
            model.addAttribute("artistes", artisteRepository.findAll());
            model.addAttribute("spectacle", spectacle.get());
        }
        return "spectacle_edit";
    }

    /**
     * Méthode qui renvoie les informations du formulaire pour modifier un spectacle
     * @param spectacle
     * @return
     */
    @PostMapping("/admin/edit/spectacle")
    public String postEdit(@ModelAttribute Spectacle spectacle){
        spectacleRepository.save(spectacle);
        return "redirect:/admin";
    }
    /**
     * Méthode que affiche le formulaire ainsi que les informations pour la modification
     * d'un artiste
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/admin/edit/artiste")
    public String adminEditArtiste(Model model, @RequestParam Long id) {
        Optional<Artiste> artiste = artisteRepository.findById(id);
        if(artiste.isPresent()) {

            model.addAttribute("spectacles", spectacleRepository.findAll());
            model.addAttribute("artiste", artiste.get());
        }
        return "artiste_edit";
    }

    /**
     * Méthode qui renvoie les informations du formulaire pour modifier un artiste
     * @param artiste
     * @return
     */
    @PostMapping("/admin/edit/artiste")
    public String postEditArtiste(@ModelAttribute Artiste artiste){
        artisteRepository.save(artiste);
        return "redirect:/admin";
    }


    /**
     * Méthode qui permet de supprimer un spectacle dans le espace admin
     * @param id
     * @return
     */
    @GetMapping("/admin/delete/spectacle")
    public String deleteSpectacle(@RequestParam Long id) {
        spectacleRepository.deleteById(id);
        return "redirect:/admin";
    }

    /**
     * Méthode qui permet de supprimer un artiste dans le espace admin
     * @param id
     * @return
     */
    @GetMapping("/admin/delete/artiste")
    public String deleteArtiste(@RequestParam Long id) {
        artisteRepository.deleteById(id);
        return "redirect:/admin";
    }

    /**
     *  Méthode qui permet d'afficher le formulaire pour ajouter un spectacle dans le espace admin
     * @param model
     * @return
     */
    @GetMapping("admin/create/artiste")
    public String getArtisteForm(Model model) {
        model.addAttribute("spectacles", spectacleRepository.findAll());
        model.addAttribute("artiste", new Artiste());
        return "artiste_form";
    }

    /**
     * Méthode que renvoie les informations rentrées dans le formulaire
     * @param artiste
     * @param bindingResult
     * @return
     */
    @PostMapping("admin/create/artiste")
    public String postArtisteForm(@Valid Artiste artiste, BindingResult bindingResult) {

        artisteRepository.save(artiste);

        if(bindingResult.hasErrors()) {
            return "artiste_form";
        }
        return "redirect:/artistes";

    }

}
