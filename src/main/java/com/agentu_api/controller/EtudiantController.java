package com.agentu_api.controller;
import com.agentu_api.bo.Agent;
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
    Etudiant getEtudiant(@PathVariable String ine){
        return this.etudiantService.getEtudiant(ine);
    }

    @PostMapping(value = "/",consumes = "application/json")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return this.etudiantService.creerEtudiant(etudiant);
    }
    @DeleteMapping(value = "/delete/{idEtudiant}")
    void supprimerEtdiant(@PathVariable String idEtudiant){
        this.etudiantService.supprimerEtudiant(idEtudiant);
    }

    @PutMapping("/")
    void modifierEtdiant(@RequestBody Etudiant etudiant){
        this.etudiantService.modifierEtudiant(etudiant);
    }

}
