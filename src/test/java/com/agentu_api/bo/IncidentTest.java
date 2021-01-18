package com.agentu_api.bo;

import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IncidentTest {

    @Test
    void Incident_doitEtreEntity(){
        assertNotNull(Incident.class.getAnnotation(Entity.class));
    }

    @Test
    void IncidentID_doitEtreUnId() throws NoSuchFieldException {
        assertNotNull(Incident.class.getDeclaredField("id").getAnnotation(Id.class));
    }

    @Test
    void EtudiantIne_doitPasEtreNull() throws NoSuchFieldException {
        assertNotNull(Incident.class.getDeclaredField("id").getAnnotation(NonNull.class));
    }

    @Test
    void IncidentCleEtrangere() throws NoSuchFieldException {
        assertNotNull(Incident.class.getDeclaredField("etudiant").getAnnotation(OneToOne.class));
    }
}
