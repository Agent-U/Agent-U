package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }


    @Override
    public Iterable<Etudiant> getListeEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiant(String name) {
        return etudiantRepository.findById(name).orElse(null);
    }

    @Override
    public Etudiant creerEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
}
