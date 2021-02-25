package com.agentu_api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class EtudiantRepositoryTest {

    @Autowired
    private EtudiantRepository repository;

    @Test
    void etudiantRepository_doitExtendsCrudRepository() throws NoSuchMethodException {
        assertTrue(CrudRepository.class.isAssignableFrom(EtudiantRepository.class));
    }

    @Test
    void etudiantRepositorydoitEtreInstancierParSpring(){
        assertNotNull(repository);
    }

}
