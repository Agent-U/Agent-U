package com.agentu_api.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Etudiant {

    public Etudiant(@NonNull String ine) {
        this.ine = ine;
    }

    @Id
    @NonNull
    private String ine;
    private String nom;
    private String prenom;
    private String mail;
    private String motDePasse;
    private int petiteEnveloppe;
    private int grandeEnveloppe;
    private int avisPassage ;
    private int colis;

    public int getDatePetiteEnveloppe() {
        return datePetiteEnveloppe;
    }

    public void setDatePetiteEnveloppe(int datePetiteEnveloppe) {
        this.datePetiteEnveloppe = datePetiteEnveloppe;
    }

    public int getDateGrandeEnveloppe() {
        return dateGrandeEnveloppe;
    }

    public void setDateGrandeEnveloppe(int dateGrandeEnveloppe) {
        this.dateGrandeEnveloppe = dateGrandeEnveloppe;
    }

    public int getDateAvisPassage() {
        return dateAvisPassage;
    }

    public void setDateAvisPassage(int dateAvisPassage) {
        this.dateAvisPassage = dateAvisPassage;
    }

    public int getDateColis() {
        return dateColis;
    }

    public void setDateColis(int dateColis) {
        this.dateColis = dateColis;
    }

    private int datePetiteEnveloppe;
    private int dateGrandeEnveloppe;
    private int dateAvisPassage ;
    private int dateColis;
    private String chambre;

    @OneToMany(mappedBy="etudiant")//,cascade = CascadeType.ALL)
    @ElementCollection(targetClass=Incident.class)
    @JsonIgnoreProperties({ "etudiant" })
    private List<Incident> incidents = new ArrayList<>();


    @OneToMany(mappedBy="etudiant")//,cascade = CascadeType.ALL)
    @ElementCollection(targetClass=RendezVous.class)
    @JsonIgnoreProperties({ "etudiant"})
    private List<RendezVous> rendezVous = new ArrayList<>();

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Incident incident) {
        this.incidents.add(incident);
    }

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rdv) {
        this.rendezVous.add(rdv);
    }


    public Etudiant() {

    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getPetiteEnveloppe() {
        return petiteEnveloppe;
    }

    public void setPetiteEnveloppe(int petiteEnveloppe) {
        this.petiteEnveloppe = petiteEnveloppe;
    }

    public int getGrandeEnveloppe() {
        return grandeEnveloppe;
    }

    public void setGrandeEnveloppe(int grandeEnveloppe) {
        this.grandeEnveloppe = grandeEnveloppe;
    }

    public int getAvisPassage() {
        return avisPassage;
    }

    public void setAvisPassage(int avisPassage) {
        this.avisPassage = avisPassage;
    }

    public int getColis() {
        return colis;
    }

    public void setColis(int colis) {
        this.colis = colis;
    }

    public String getChambre() {
        return chambre;
    }

    public void setChambre(String chambre) {
        this.chambre = chambre;
    }




}
