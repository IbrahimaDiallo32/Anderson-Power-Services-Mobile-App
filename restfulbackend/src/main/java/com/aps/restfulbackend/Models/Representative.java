package com.aps.restfulbackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Representative {
    @Id
    private int id;
    private String first_name;
    private String last_name;
    private String phonenumber;
    private String rep_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRep_type() {
        return rep_type;
    }

    public void setRep_type(String rep_type) {
        this.rep_type = rep_type;
    }
}
