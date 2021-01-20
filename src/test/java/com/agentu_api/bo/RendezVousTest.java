package com.agentu_api.bo;

import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RendezVousTest {

    @Test
    void RendezVous_doitEtreEntity(){
        assertNotNull(RendezVous.class.getAnnotation(Entity.class));
    }

    @Test
    void RendezVousID_doitEtreUnId() throws NoSuchFieldException {
        assertNotNull(RendezVous.class.getDeclaredField("id").getAnnotation(Id.class));
    }

    @Test
    void RendezVousIne_doitPasEtreNull() throws NoSuchFieldException {
        assertNotNull(RendezVous.class.getDeclaredField("id").getAnnotation(NonNull.class));
    }

}
