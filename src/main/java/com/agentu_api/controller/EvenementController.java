package com.agentu_api.controller;


import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Evenement;
import com.agentu_api.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/evenements")
public class EvenementController {

    @Autowired
    private final EvenementService evenementService;



    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping(value="/")
    Iterable<Evenement> getAllEvenement(){
        return this.evenementService.getListeEvenement();
    }

    @GetMapping(value="/{id}")
    Evenement getEvenement(@PathVariable String id){
        return this.evenementService.getEvenement(id);
    }

    @PostMapping(value = "/",consumes = "application/json")
    Evenement addEvenement(@RequestBody Evenement evenement){
        return this.evenementService.creerEvenement(evenement);
    }
    @DeleteMapping(value = "/delete/{idEvenement}")
    void supprimerEvenement(@PathVariable String idEvenement){
        this.evenementService.supprimerEvenement(idEvenement);
    }

    @PutMapping("/")
    void modifierEvenement(@RequestBody Evenement evenement){
        this.evenementService.modifierEvenement(evenement);
    }

}
