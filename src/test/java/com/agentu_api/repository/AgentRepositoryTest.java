package com.agentu_api.repository;

import com.agentu_api.bo.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class AgentRepositoryTest {

    @Autowired
    private AgentRepository repository;

    @Test
    void agentRepository_shouldExtendsCrudRepository() throws NoSuchMethodException {
        assertTrue(CrudRepository.class.isAssignableFrom(AgentRepository.class));
    }

    @Test
    void agentRepositoryShouldBeInstanciedBySpring(){
        assertNotNull(repository);
    }



}
