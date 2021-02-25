package com.agentu_api.controller;


import com.agentu_api.bo.Evenement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EvenementControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EvenementController controller;

    @Test
    void EvenementController_shouldBeInstanciated(){
        assertNotNull(controller);
    }

    @Test
    void getEvenements_withId1_shouldReturnAgentWithId1() {

        Evenement[] evenements = this.restTemplate.getForObject("http://localhost:" + port + "/evenements/", Evenement[].class);
        var event = this.restTemplate.getForObject("http://localhost:" + port + "/evenements/1", Evenement.class);
        if (evenements.length == 0) {
            assertNull(event);
        } else {
            assertNotNull(event);
            assertEquals(1, event.getId());
        }
    }

    @Test
    void getAllEvenements_shouldReturnCoherentsIds() {
        var evenements = this.restTemplate.getForObject("http://localhost:" + port + "/evenements/", Evenement[].class);
        assertNotNull(evenements);
        if (evenements.length != 0) {
            var i = evenements.length;
            assertEquals((long) 1, evenements[0].getId());
            assertEquals((long) i, evenements[i-1].getId());
            assertEquals(1, evenements[0].getId());
        }

    }

}