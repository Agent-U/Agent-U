package com.agentu_api.bo;

import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EvenementTest {

    @Test
    void EvenementDoitEtreUneEntity() {
        assertNotNull(Evenement.class.getAnnotation(Entity.class));
    }

    @Test
    void EvenementIdDoitEtreUnId() throws NoSuchFieldException {
        assertNotNull(Evenement.class.getDeclaredField("id").getAnnotation(Id.class));
    }

    @Test
    void EvenementIdDoitPasEtreNull() throws NoSuchFieldException {
        assertNotNull(Evenement.class.getDeclaredField("id").getAnnotation(NonNull.class));
    }
}