package com.agentu_api.service;


import com.agentu_api.bo.RendezVous;
import com.agentu_api.repository.RendezVousRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RendezVousServiceImplTest {

    @Test
    void getListeRendezVous_doitAppelerLeRepository() {
        var rendezVousRepo = mock(RendezVousRepository.class);
        var rendezVousService = new RendezVousServiceImpl(rendezVousRepo);

        rendezVousService.getListRendezVous();

        verify(rendezVousRepo).findAll();
    }

    @Test
    void getIncident_doitAppelerLeRepository() {
        var rendezVousRepo = mock(RendezVousRepository.class);
        var rendezVousService = new RendezVousServiceImpl(rendezVousRepo);

        rendezVousService.getRendezVous("rdv10");

        verify(rendezVousRepo).findById("rdv10");
    }

    @Test
    void createIncident_shouldCallTheRepository() {
        var rendezVousRepo = mock(RendezVousRepository.class);
        var rendezVousService = new RendezVousServiceImpl(rendezVousRepo);

        var rendezVous = new RendezVous();
        rendezVousService.creerRendezVous(rendezVous);

        verify(rendezVousRepo).save(rendezVous);
    }
}
