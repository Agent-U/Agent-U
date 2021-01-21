package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private BCryptPasswordEncoder encoder;
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
        etudiant.setMotDePasse(encoder.encode(etudiant.getMotDePasse()));
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void supprimerEtudiant(String idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    /**
     * Si l'étudiant  existe déja, save va modifier l'étudiant
     * sinon, elle va créer un nouvel étudiant
     * */
    @Override
    public void modifierEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }
}
