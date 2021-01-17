package com.agentu_api.bo;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Evenement {
    @Id
    @NonNull
    private int id;
    private String titre;
    private String image_url;
    private String Detail;


    public Evenement() {

    }

    public int getId() {
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

    public void setId(int id) {
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