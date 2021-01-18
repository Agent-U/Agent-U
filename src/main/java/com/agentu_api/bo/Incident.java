package com.agentu_api.bo;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Incident {

    @Id
    @NonNull
    private String id;
    private Date date;
    private String motif;


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
