package com.agentu_api.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;


@Entity
public class RendezVous {

    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String motif;



    @JsonIgnoreProperties({ "rendezVous" })
    @JoinColumn(name = "id")
    private Agent agent;

    @JsonIgnoreProperties({ "rendezVous" })
    @JoinColumn(name = "ine")
    private Etudiant etudiant;

    @ManyToOne(targetEntity=Etudiant.class)
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }


    @ManyToOne(targetEntity=Agent.class)
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }


    @Id
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getMotif() {
        return motif;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
}



