package com.agentu_api.controller;


import com.agentu_api.bo.Incident;
import com.agentu_api.bo.RendezVous;
import com.agentu_api.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rendezvous")
public class RendezVousController {

    @Autowired
    private final RendezVousService rendezVousService;


    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }

    @GetMapping(value="/")
    Iterable<RendezVous> getAllRendezVous(){
        return this.rendezVousService.getListeRendezVous();
    }

    @GetMapping(value="/{id}")
    RendezVous getRendezVous(@PathVariable String id){
        return this.rendezVousService.getRendezVous(id);
    }
}
