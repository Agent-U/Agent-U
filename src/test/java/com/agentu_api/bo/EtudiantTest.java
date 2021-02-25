package com.agentu_api.bo;
import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import static org.junit.jupiter.api.Assertions.*;

public class EtudiantTest {

    @Test
    void Etudiant_doitEtreUneEntity(){
        assertNotNull(Etudiant.class.getAnnotation(Entity.class));
    }

    @Test
    void EtudiantIne_doitEtreUnId() throws NoSuchFieldException {
        assertNotNull(Etudiant.class.getDeclaredField("ine").getAnnotation(Id.class));
    }

    @Test
    void EtudiantIne_doitPasEtreNull() throws NoSuchFieldException {
        assertNotNull(Etudiant.class.getDeclaredField("ine").getAnnotation(NonNull.class));
    }

}
