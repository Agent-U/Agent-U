package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Evenement;
import com.agentu_api.repository.EtudiantRepository;
import com.agentu_api.repository.EvenementRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EvenementServiceImplTest {

    @Test
    void getAllEvenements_shouldCallTheRepository() {
        var evenementRepository = mock(EvenementRepository.class);
        var evenementService = new EvenementServiceImpl(evenementRepository);

        evenementService.getListeEvenement();

        verify(evenementRepository).findAll();
    }

    @Test
    void getEvenement_shouldCallTheRepository() {
        var evenementRepository = mock(EvenementRepository.class);
        var evenementService = new EvenementServiceImpl(evenementRepository);

        evenementService.getEvenement("id1");
        verify(evenementRepository).findById("id1");
    }

    @Test
    void createEvenement_shouldCallTheRepository() {
        var evenementRepository = mock(EvenementRepository.class);
        var evenementService = new EvenementServiceImpl(evenementRepository);

        var evenement = new Evenement();
        evenementService.creerEvenement(evenement);

        verify(evenementRepository).save(evenement);
    }



}
