package com.agentu_api.service;

import com.agentu_api.bo.Agent;
import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.RendezVous;
import com.agentu_api.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendezVousServiceImpl implements RendezVousService{
    @Autowired
    private RendezVousRepository rendezVousRepository;

    public RendezVousServiceImpl(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Iterable<RendezVous> getListeRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous getRendezVous(String id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public RendezVous creerRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }
}
