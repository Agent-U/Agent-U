package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Incident;
import com.agentu_api.repository.EtudiantRepository;
import com.agentu_api.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentServiceImpl implements IncidentService{



    @Autowired
    private IncidentRepository incidentRepository;

    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public Iterable<Incident> getListeIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    public Incident getIncident(String id) {
        return incidentRepository.findById(id).orElse(null);
    }

    @Override
    public Incident creerIncident(Incident incident) {
        return incidentRepository.save(incident);
    }
}
