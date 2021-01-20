package com.agentu_api.controller;


import com.agentu_api.bo.Incident;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IncidentControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IncidentController controller;

    @Test
    void EvenementController_shouldBeInstanciated(){
        assertNotNull(controller);
    }

    @Test
    void getIncidents_withId1_shouldReturnAgentWithId1() {

        Incident[] incidents = this.restTemplate.getForObject("http://localhost:" + port + "/incidents/", Incident[].class);
        var incident = this.restTemplate.getForObject("http://localhost:" + port + "/incidents/1", Incident.class);
        if (incidents.length == 0) {
            assertNull(incident);
        } else {
            assertNotNull(incident);
            assertEquals(1, incident.getId());
        }
    }

    @Test
    void getAllIncidents_shouldReturnCoherentsIds() {
        var incidents = this.restTemplate.getForObject("http://localhost:" + port + "/incidents/", Incident[].class);
        assertNotNull(incidents);
        if (incidents.length != 0) {
            var i = incidents.length;
            assertEquals((long) 1, incidents[0].getId());
            assertEquals((long) i, incidents[i-1].getId());
            assertEquals(1, incidents[0].getId());
        }

    }

}