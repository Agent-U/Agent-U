package com.agentu_api.bo;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evenement {
    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String titre;
    private String image_url;
    private String Detail;


    public Evenement(String id) {
        this.id = id;
    }

    public Evenement() {

    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getDetail() {
        return Detail;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }
}
