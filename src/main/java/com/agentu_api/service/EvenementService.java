package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Evenement;

public interface EvenementService {
    Iterable<Evenement> getListeEvenement();
    Evenement getEvenement(String id);
    Evenement creerEvenement(Evenement evenement);
    void supprimerEvenement(String idEvenement);
    void modifierEvenement(Evenement evenement);
}
