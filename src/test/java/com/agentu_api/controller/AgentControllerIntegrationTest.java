package com.agentu_api.controller;


import com.agentu_api.bo.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;

import static org.junit.jupiter.api.Assertions.*;

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

        Agent[] agents = this.restTemplate.getForObject("http://localhost:" + port + "/agents/", Agent[].class);
        var agent1 = this.restTemplate.getForObject("http://localhost:" + port + "/agents/1", Agent.class);
        if (agents.length == 0) {
            assertNull(agent1);
        } else {
            assertNotNull(agent1);
            assertEquals(1, agent1.getId());
        }
    }

    @Test
    void getAllAgents_shouldReturnCoherentsIds() {
        var agents = this.restTemplate.getForObject("http://localhost:" + port + "/agents/", Agent[].class);
        assertNotNull(agents);
        if (agents.length != 0) {
            var i = agents.length;
            assertEquals((long) 1, agents[0].getId());
            assertEquals((long) i, agents[i-1].getId());
            assertEquals(1, agents[0].getId());
        }

    }




}