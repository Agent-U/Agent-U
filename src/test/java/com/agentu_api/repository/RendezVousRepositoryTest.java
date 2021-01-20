package com.agentu_api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class RendezVousRepositoryTest {

    @Autowired
    private AgentRepository repository;

    @Test
    void RendezVousRepository_doitExtendsCrudRepository() throws NoSuchMethodException {
        assertTrue(CrudRepository.class.isAssignableFrom(RendezVousRepository.class));
    }

    @Test
    void RendezVousRepositorydoitEtreInstancierParSpring(){
        assertNotNull(repository);
    }


}
