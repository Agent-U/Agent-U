package com.agentu_api.controller;


import com.agentu_api.bo.RendezVous;

import com.agentu_api.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rendezVous")
public class RendezVousController {

    @Autowired
    private final RendezVousService rendezVousService;


    RendezVousController(RendezVousService rendezVousService){
        this.rendezVousService = rendezVousService;
    }

    @GetMapping(value="/")
    Iterable<RendezVous> getAllRendezVous(){
        return this.rendezVousService.getListRendezVous();
    }

    @GetMapping(value="/{id}")
    RendezVous getRendezVous(@PathVariable String id){
        return this.rendezVousService.getRendezVous(id);
    }

    @PostMapping(value = "/",consumes = "application/json")
    RendezVous addRendezVous(@RequestBody RendezVous rendezVous){
        return this.rendezVousService.creerRendezVous(rendezVous);
    }
    @DeleteMapping(value = "/delete/{idRendezVous}")
    void supprimerRendezVous(@PathVariable String idRendezVous){
        this.rendezVousService.supprimerRendezVous(idRendezVous);
    }

    @PutMapping("/")
    void modifierRendezVous(@RequestBody RendezVous rendezVous){
        this.rendezVousService.modifierRendezVous(rendezVous);
    }

}
