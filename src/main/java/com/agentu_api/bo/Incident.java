package com.agentu_api.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Incident {

    @Id
    @NonNull
    private String id;
    private Date date;
    private String motif;


    @ManyToOne(targetEntity=Etudiant.class)
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }


    @JsonIgnoreProperties({ "incidents" })
    @JoinColumn(name = "ine")
    private Etudiant etudiant;


    @Id
    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getMotif() {
        return motif;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

}
