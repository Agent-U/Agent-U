package com.agentu_api.service;

import com.agentu_api.bo.Agent;
import com.agentu_api.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {

    private AgentRepository agentRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Iterable<Agent> getAllAgents() {
        return this.agentRepository.findAll();
    }

    @Override
    public Agent getAgent(String id) {
        // TODO
        return this.agentRepository.findById(id).orElse(null);
    }

    @Override
    public Agent createAgent(Agent agent) {
        // TODO
        this.agentRepository.save(agent);
        return agent;
    }

}
