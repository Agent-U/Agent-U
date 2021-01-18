package com.agentu_api.repository;

import com.agentu_api.bo.Evenement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EvenementRepositoryTest {

    @Autowired
    EvenementRepository evenementRepository;

    @Test
    void evenementRepository_doitExtendsCrudRepository() throws NoSuchMethodException {
        assertTrue(CrudRepository.class.isAssignableFrom(EvenementRepository.class));
    }

    @Test
    void evenementRepositorydoitEtreInstancierParSpring(){
        assertNotNull(evenementRepository);
    }

    @Test
    void testSave(){
        var evt = new Evenement("id1");

        evenementRepository.save(evt);

        var saved = evenementRepository.findById(evt.getId()).orElse(null);

        assertEquals("id1", saved.getId());
    }


}
