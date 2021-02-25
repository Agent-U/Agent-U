package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Incident;

public interface IncidentService {
    Iterable<Incident> getListeIncidents();
    Incident getIncident(Long id);
    Incident creerIncident(Incident incident );
    void supprimerIncident(Long idIncident);
    void modifierIncident(Incident incident);
}
