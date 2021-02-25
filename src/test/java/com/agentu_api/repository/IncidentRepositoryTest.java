package com.agentu_api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class IncidentRepositoryTest {
    @Autowired
    private EtudiantRepository repository;

    @Test
    void incidentRepository_doitExtendsCrudRepository() throws NoSuchMethodException {
        assertTrue(CrudRepository.class.isAssignableFrom(IncidentRepository.class));
    }

    @Test
    void incidentRepositorydoitEtreInstancierParSpring(){
        assertNotNull(repository);
    }

}
