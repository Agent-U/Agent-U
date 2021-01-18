package com.agentu_api.controller;

import com.agentu_api.service.EtudiantService;
import com.agentu_api.service.EvenementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class EvenementControllerTest {
    @Mock
    private EvenementService evenementService;

    @InjectMocks
    private EvenementController evenementController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllEvenement_shouldCallTheService() {
        evenementController.getAllEvenement();

        verify(evenementService).getListeEvenement();
    }

    @Test
    void getEvenement_shouldCallTheService() {
        evenementController.getEvenement("id1");

        verify(evenementService).getEvenement("id1");
    }
}
