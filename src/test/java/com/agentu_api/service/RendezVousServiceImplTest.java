package com.agentu_api.service;

import com.agentu_api.bo.Evenement;
import com.agentu_api.bo.RendezVous;
import com.agentu_api.repository.EvenementRepository;
import com.agentu_api.repository.RendezVousRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RendezVousServiceImplTest {

    @Test
    void getAllRendezVOus_shouldCallTheRepository() {
        var rendezVousRepository = mock(RendezVousRepository.class);
        var rendezVousService = new RendezVousServiceImpl(rendezVousRepository);

        rendezVousService.getListeRendezVous();

        verify(rendezVousRepository).findAll();
    }

    @Test
    void getRendezVOus_shouldCallTheRepository() {
        var rendezVousRepository = mock(RendezVousRepository.class);
        var rendezVousService = new RendezVousServiceImpl(rendezVousRepository);

        rendezVousService.getRendezVous("id1");
        verify(rendezVousRepository).findById("id1");
    }

    @Test
    void createEvenement_shouldCallTheRepository() {
        var rendezVousRepository = mock(RendezVousRepository.class);
        var rendezVousService = new RendezVousServiceImpl(rendezVousRepository);

        var rendezVous = new RendezVous();
        rendezVousService.creerRendezVous(rendezVous);

        verify(rendezVousRepository).save(rendezVous);
    }
}
