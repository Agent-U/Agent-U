package com.agentu_api.controller;

import com.agentu_api.bo.Incident;
import com.agentu_api.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    @PostMapping(value = "/upImg")
    void uploadImage(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {


        byte[] bytes = file.getBytes();
        Path path = Paths.get("./../FrontEndEtudiant/src/assets/incidents/" + file.getOriginalFilename());
        Files.write(path, bytes);
        path = Paths.get("./../FrontEndAgent/src/assets/incidents/" + file.getOriginalFilename());
        Files.write(path, bytes);


        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
    }


}
