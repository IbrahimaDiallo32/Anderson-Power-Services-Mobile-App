package com.aps.restfulbackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ad")
public class Ad {

    @Id
    int id;
    String ad_text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd_text() {
        return ad_text;
    }

    public void setAd_text(String ad_text) {
        this.ad_text = ad_text;
    }
}
