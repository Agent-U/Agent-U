package com.agentu_api.controller;


import com.agentu_api.bo.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AgentControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AgentController controller;

    @Test
    void AgentController_shouldBeInstanciated(){
        assertNotNull(controller);
    }

    @Test
    void getAgent_withId1_shouldReturnAgentWithId1() {
        var agent1 = this.restTemplate.getForObject("http://localhost:" + port + "/agents/1", Agent.class);
        assertNotNull(agent1);
        assertEquals("1", agent1.getId());
    }

    @Test
    void getAllAgents_shouldReturnAgentsWithId1And7() {
        var agents = this.restTemplate.getForObject("http://localhost:" + port + "/agents/", Agent[].class);
        assertNotNull(agents);
        assertEquals(7, agents.length);
        assertEquals("1", agents[0].getId());
        assertEquals("7", agents[6].getId());
    }


}