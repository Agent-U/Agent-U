package com.agentu_api.service;

import com.agentu_api.bo.Incident;
import com.agentu_api.bo.RendezVous;

public interface RendezVousService {

    Iterable<RendezVous> getListRendezVous();
    RendezVous getRendezVous(Long id);
    RendezVous creerRendezVous(RendezVous rendezVous );
    void supprimerRendezVous(Long idRendezVous);
    void modifierRendezVous(RendezVous rendezVous);
}
