package com.agentu_api.service;

import com.agentu_api.bo.Incident;
import com.agentu_api.bo.RendezVous;

public interface RendezVousService {

    Iterable<RendezVous> getListRendezVous();
    RendezVous getRendezVous(String id);
    RendezVous creerRendezVous(RendezVous rendezVous );
    void supprimerRendezVous(String idRendezVous);
    void modifierRendezVous(RendezVous rendezVous);
}
