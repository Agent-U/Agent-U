package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;

public interface EtudiantService {

    Iterable<Etudiant> getListeEtudiants();
    Etudiant getEtudiant(String name);
    Etudiant creerEtudiant(Etudiant etudiant);
}
