package com.agentu_api.controller;


import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Evenement;
import com.agentu_api.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import com.agentu_api.uploadingfiles.storage.StorageService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    Evenement getEvenement(@PathVariable Long id){
        return this.evenementService.getEvenement(id);
    }

    @PostMapping(value = "/",consumes = "application/json")
    Evenement addEvenement(@RequestBody Evenement evenement){
        return this.evenementService.creerEvenement(evenement);
    }

    @DeleteMapping(value = "/delete/{idEvenement}")
    void supprimerEvenement(@PathVariable Long idEvenement){
        this.evenementService.supprimerEvenement(idEvenement);
    }

    @PutMapping("/")
    void modifierEvenement(@RequestBody Evenement evenement){
        this.evenementService.modifierEvenement(evenement);
    }

    @PostMapping(value = "/upImg")
    void uploadImage(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        //this.evenementService.upImage(file);

        byte[] bytes = file.getBytes();
        Path path = Paths.get("./images/events/" + file.getOriginalFilename());
        Files.write(path, bytes);


        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
    }

}
