package com.agentu_api.controller;

import com.agentu_api.bo.Agent;
import com.agentu_api.bo.Etudiant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EtudiantControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EtudiantController controller;

    @Test
    void AgentController_shouldBeInstanciated(){
        assertNotNull(controller);
    }

    @Test
    void getEtudiants_withId1_shouldReturnAgentWithId1() {

        Etudiant[] etudiants = this.restTemplate.getForObject("http://localhost:" + port + "/etudiants/", Etudiant[].class);
        var etu = this.restTemplate.getForObject("http://localhost:" + port + "/etudiants/1", Etudiant.class);
        if (etudiants.length == 0) {
            assertNull(etu);
        } else {
            assertNotNull(etu);
            assertEquals(1, etu.getIne());
        }
    }

    @Test
    void getAllEtudiants_shouldReturnCoherentsIds() {
        var etudiants = this.restTemplate.getForObject("http://localhost:" + port + "/etudiants/", Etudiant[].class);
        assertNotNull(etudiants);
        if (etudiants.length != 0) {
            var i = etudiants.length;
            assertEquals((long) 1, etudiants[0].getIne());
            assertEquals((long) i, etudiants[i-1].getIne());
            assertEquals(1, etudiants[0].getIne());
        }

    }

}
