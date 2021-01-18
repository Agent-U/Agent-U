package com.agentu_api.controller;

import com.agentu_api.service.EtudiantService;
import com.agentu_api.service.IncidentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class IncidentControllerTest {
    @Mock
    private IncidentService incidentService;

    @InjectMocks
    private IncidentController incidentController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllIncidents_shouldCallTheService() {
        incidentController.getAllIncidents();

        verify(incidentService).getListeIncidents();
    }

    @Test
    void getTrainer_shouldCallTheService() {
        incidentController.getIncident("Inc10");

        verify(incidentService).getIncident("Inc10");
    }

}
