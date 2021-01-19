package com.agentu_api.service;
import com.agentu_api.bo.Etudiant;
import com.agentu_api.repository.EtudiantRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EtudiantServiceImplTest {

    @Test
    void getAllTrainers_shouldCallTheRepository() {
        var etudiantRepo = mock(EtudiantRepository.class);
        var etudiantService = new EtudiantServiceImpl(etudiantRepo);

        etudiantService.getListeEtudiants();

        verify(etudiantRepo).findAll();
    }

    @Test
    void getEtudiant_shouldCallTheRepository() {
        var etudiantRepo = mock(EtudiantRepository.class);
        var etudiantService = new EtudiantServiceImpl(etudiantRepo);

        etudiantService.getEtudiant("Bob");

        verify(etudiantRepo).findById("Bob");
    }

    @Test
    void createEtudiant_shouldCallTheRepository() {
        var etudiantRepo = mock(EtudiantRepository.class);
        var etudiantService = new EtudiantServiceImpl(etudiantRepo);

        var etudiant = new Etudiant();
        etudiantService.creerEtudiant(etudiant);

        verify(etudiantRepo).save(etudiant);
    }
}
