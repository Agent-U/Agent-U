package com.agentu_api.controller;
import com.agentu_api.bo.Etudiant;
import com.agentu_api.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/etudiants")
public class EtudiantController {

    @Autowired
    private final EtudiantService etudiantService;


    EtudiantController(EtudiantService etudiantService){
        this.etudiantService = etudiantService;
    }

    @GetMapping(value="/")
    Iterable<Etudiant> getAllEtudiants(){
        return this.etudiantService.getListeEtudiants();
    }

    @GetMapping(value="/{ine}")
    Etudiant getTrainer(@PathVariable String ine){
        return this.etudiantService.getEtudiant(ine);
    }

}
