package com.agentu_api.controller;

import com.agentu_api.service.IncidentService;
import com.agentu_api.service.RendezVousService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class RendezVousControllerTest {
    @Mock
    private RendezVousService rendezVousService;

    @InjectMocks
    private RendezVousController rendezVousController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllRendezVous_shouldCallTheService() {
        rendezVousController.getAllRendezVous();

        verify(rendezVousService).getListeRendezVous();
    }

    @Test
    void getRendezVous_shouldCallTheService() {
        rendezVousController.getRendezVous("1");

        verify(rendezVousService).getRendezVous("1");
    }
}
