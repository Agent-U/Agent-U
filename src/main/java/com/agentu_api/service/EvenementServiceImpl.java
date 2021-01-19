package com.agentu_api.service;


import com.agentu_api.bo.Evenement;
import com.agentu_api.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvenementServiceImpl implements EvenementService{

    @Autowired
    private EvenementRepository evenementRepository;

    public EvenementServiceImpl(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    @Override
    public Iterable<Evenement> getListeEvenement() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement getEvenement(String id) {
        return evenementRepository.findById(id).orElse(null);
    }

    @Override
    public Evenement creerEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public void supprimerEvenement(String idEvenement) {
        evenementRepository.deleteById(idEvenement);
    }

    @Override
    public void modifierEvenement(Evenement evenement) {
        evenementRepository.save(evenement);
    }
}
