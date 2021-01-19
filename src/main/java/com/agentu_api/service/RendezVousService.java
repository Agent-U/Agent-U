package com.agentu_api.service;

import com.agentu_api.bo.Agent;
import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Incident;
import com.agentu_api.bo.RendezVous;

public interface RendezVousService {

    Iterable<RendezVous> getListeRendezVous();
    RendezVous getRendezVous(String id);
    RendezVous creerRendezVous(RendezVous rendezVous);
}
