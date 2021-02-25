package com.agentu_api.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Incident {

    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String motif;
    private String lieu;
    private String description;
    private String imageUrl;
    private int etat;

    @JsonIgnoreProperties({ "incidents" })
    @JoinColumn(name = "ine")
    private Etudiant etudiant;



    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }




    @ManyToOne(targetEntity=Etudiant.class)
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }



    @Id
    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getMotif() {
        return motif;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

}
