package com.agentu_api.service;


import com.agentu_api.bo.Agent;
import com.agentu_api.repository.AgentRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AgentServiceImplTest {

    @Test
    void getAllAgent_shouldCallTheRepository() {
        var agentRepo = mock(AgentRepository.class);
        var agentService = new AgentServiceImpl(agentRepo);

        agentService.getAllAgents();

        verify(agentRepo).findAll();
    }



    @Test
    void createAgent_shouldCallTheRepository() {
        var agentRepo = mock(AgentRepository.class);
        var agentService = new AgentServiceImpl(agentRepo);

        var agent = new Agent();
        agentService.createAgent(agent);

        verify(agentRepo).save(agent);
    }
}
