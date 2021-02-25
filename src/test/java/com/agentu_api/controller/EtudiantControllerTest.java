package com.agentu_api.controller;

import com.agentu_api.service.EtudiantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class EtudiantControllerTest {

    @Mock
    private EtudiantService etudiantService;

    @InjectMocks
    private EtudiantController etudiantController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllEtudiants_shouldCallTheService() {
        etudiantController.getAllEtudiants();

        verify(etudiantService).getListeEtudiants();
    }

    @Test
    void getEtudiant_shouldCallTheService() {
        etudiantController.getEtudiant("Bob");

        verify(etudiantService).getEtudiant("Bob");
    }
}
