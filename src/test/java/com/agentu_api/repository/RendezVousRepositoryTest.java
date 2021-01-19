package com.agentu_api.repository;

import com.agentu_api.bo.RendezVous;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RendezVousRepositoryTest {

    @Autowired
    RendezVousRepository rendezVousRepository;

    @Test
    void rendezVousRepository_doitExtendsCrudRepository() throws NoSuchMethodException {
        assertTrue(CrudRepository.class.isAssignableFrom(RendezVousRepository.class));
    }

    @Test
    void rendezVousRepository_doitEtreInstancierParSpring(){
        assertNotNull(rendezVousRepository);
    }

    @Test
    void testSave(){
        var rdv = new RendezVous();
        rdv.setId("rd1");
        rendezVousRepository.save(rdv);


        var saved = rendezVousRepository.findById(rdv.getId()).orElse(null);

        Assertions.assertEquals("rd1", saved.getId());
    }

}
