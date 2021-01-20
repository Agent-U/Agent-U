package com.agentu_api.controller;

import com.agentu_api.bo.Incident;
import com.agentu_api.bo.RendezVous;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RendezVousControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RendezVousController controller;

    @Test
    void EvenementController_shouldBeInstanciated(){
        assertNotNull(controller);
    }

    @Test
    void getRendezVous_withId1_shouldReturnAgentWithId1() {

        RendezVous[] rdvs = this.restTemplate.getForObject("http://localhost:" + port + "/rendezVous/", RendezVous[].class);
        var rdv = this.restTemplate.getForObject("http://localhost:" + port + "/rendezVous/1", RendezVous.class);
        if (rdvs.length == 0) {
            assertNull(rdv);
        } else {
            assertNotNull(rdv);
            assertEquals(1, rdv.getId());
        }
    }

    @Test
    void getAllRendezVous_shouldReturnCoherentsIds() {
        var rdvs = this.restTemplate.getForObject("http://localhost:" + port + "/rendezVous/", RendezVous[].class);
        assertNotNull(rdvs);
        if (rdvs.length != 0) {
            var i = rdvs.length;
            assertEquals((long) 1, rdvs[0].getId());
            assertEquals((long) i, rdvs[i-1].getId());
            assertEquals(1, rdvs[0].getId());
        }

    }

}