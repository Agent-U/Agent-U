package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Evenement;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EvenementService {
    Iterable<Evenement> getListeEvenement();
    Evenement getEvenement(Long id);
    Evenement creerEvenement(Evenement evenement);
    void supprimerEvenement(Long idEvenement);
    void modifierEvenement(Evenement evenement);
}
