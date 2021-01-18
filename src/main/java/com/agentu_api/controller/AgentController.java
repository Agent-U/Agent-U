package com.agentu_api.controller;

import com.agentu_api.bo.Agent;
import com.agentu_api.bo.Etudiant;
import com.agentu_api.service.AgentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/agents")
public class AgentController {

    private final AgentService agentService;

    AgentController(AgentService agentService){
        this.agentService = agentService;
    }

    @GetMapping(value="/")
    Iterable<Agent> getAllAgents(){
        return agentService.getAllAgents();
    }

    @GetMapping(value="/{id}")
    Agent getAgent(@PathVariable String id){
        return agentService.getAgent(id);
    }





}