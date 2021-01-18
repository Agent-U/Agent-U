package com.agentu_api.controller;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Incident;
import com.agentu_api.service.EtudiantService;
import com.agentu_api.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/incident")
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
    Incident getIncident(@PathVariable String id){
        return this.incidentService.getIncident(id);
    }
}
