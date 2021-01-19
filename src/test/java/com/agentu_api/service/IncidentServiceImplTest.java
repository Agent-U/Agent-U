package com.agentu_api.service;

import com.agentu_api.bo.Etudiant;
import com.agentu_api.bo.Incident;
import com.agentu_api.repository.EtudiantRepository;
import com.agentu_api.repository.IncidentRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IncidentServiceImplTest {
    @Test
    void getListeIncidents_doitAppelerLeRepository() {
        var incidentRepo = mock(IncidentRepository.class);
        var incidentService = new IncidentServiceImpl(incidentRepo);

        incidentService.getListeIncidents();

        verify(incidentRepo).findAll();
    }

    @Test
    void getIncident_doitAppelerLeRepository() {
        var incidentRepo = mock(IncidentRepository.class);
        var incidentService = new IncidentServiceImpl(incidentRepo);

        incidentService.getIncident("incide10");

        verify(incidentRepo).findById("incide10");
    }

    @Test
    void createIncident_shouldCallTheRepository() {
        var incidentRepo = mock(IncidentRepository.class);
        var incidentService = new IncidentServiceImpl(incidentRepo);

        var incident = new Incident();
        incidentService.creerIncident(incident);

        verify(incidentRepo).save(incident);
    }
}
