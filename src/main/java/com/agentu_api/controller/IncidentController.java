package com.agentu_api.controller;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Incident;
import com.agentu_api.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/incidents")
public class IncidentController {
    @Autowired
    private final IncidentService incidentService;


    IncidentController(IncidentService incidentService){
        this.incidentService = incidentService;
    }

    @GetMapping(value="/")
    Iterable<Incident> getAllIncidents(){
        return this.incidentService.getListeIncidents();
    }

    @GetMapping(value="/{id}")
    Incident getIncident(@PathVariable Long id){
        return this.incidentService.getIncident(id);
    }

    @PostMapping(value = "/",consumes = "application/json")
    Incident addIncident(@RequestBody Incident incident){
        return this.incidentService.creerIncident(incident);
    }
    @DeleteMapping(value = "/delete/{idIncident}")
    void supprimerIncident(@PathVariable Long idIncident){
        this.incidentService.supprimerIncident(idIncident);
    }

    @PutMapping("/")
    void modifierIncident(@RequestBody Incident incident){
        this.incidentService.modifierIncident(incident);
    }

}
