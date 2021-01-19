package com.agentu_api.service;

import com.agentu_api.bo.Agent;

public interface AgentService {

    Iterable<Agent> getAllAgents();
    Agent getAgent(String id);
    Agent createAgent(Agent agent);
    void deleteAgent(String id);
    void updateAgent(Agent agent);
}
