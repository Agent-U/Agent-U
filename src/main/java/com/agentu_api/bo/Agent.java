package com.agentu_api.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Agent {

    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy="agent")//,cascade = CascadeType.ALL)
    @ElementCollection(targetClass=RendezVous.class)
    @JsonIgnoreProperties({ "agent" })
    private List<RendezVous> rendezVous = new ArrayList<>();


    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rdv) {
        this.rendezVous.add(rdv);
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
