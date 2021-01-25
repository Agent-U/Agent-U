package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

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
        if (!etudiant.getMotDePasse().isEmpty()){
            etudiant.setMotDePasse(encoder.encode(etudiant.getMotDePasse()));
        }
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
        if (etudiant.getPetiteEnveloppe() > etudiantRepository.findById(etudiant.getIne()).orElse(etudiant).getPetiteEnveloppe()){
            Date date = new Date();
            etudiant.setPetiteEnveloppeDate(date);
        }

        if (etudiant.getMotDePasse()!=null){
            etudiant.setMotDePasse(encoder.encode(etudiant.getMotDePasse()));
        }

        /*Etudiant et = etudiantRepository.findById(etudiant.getIne()).orElse(etudiant);
        if (etudiant.getMotDePasse()==null)
            etudiant.setMotDePasse(et.getMotDePasse());*/
        etudiantRepository.save(etudiant);
    }

}
