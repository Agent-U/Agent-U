package com.agentu_api.controller;


import com.agentu_api.bo.Evenement;
import com.agentu_api.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/evenement")
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

}
