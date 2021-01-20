package com.agentu_api.repository;

import com.agentu_api.bo.Agent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends CrudRepository<Agent,Long> {

}
