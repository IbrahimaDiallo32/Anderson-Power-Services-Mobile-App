package com.aps.restfulbackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="job")
public class Job {

    @Id
    private String id;
    private UUID user_id;
    private int rep_one_id;
    private int rep_two_id;
    private String email_auth;
    private String gen_size_model;
    private String install_status;
    private String customer_note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public int getRep_one_id() {
        return rep_one_id;
    }

    public void setRep_one_id(int rep_one_id) {
        this.rep_one_id = rep_one_id;
    }

    public int getRep_two_id() {
        return rep_two_id;
    }

    public void setRep_two_id(int rep_two_id) {
        this.rep_two_id = rep_two_id;
    }

    public String getEmail_auth() {
        return email_auth;
    }

    public void setEmail_auth(String email_auth) {
        this.email_auth = email_auth;
    }

    public String getGen_size_model() {
        return gen_size_model;
    }

    public void setGen_size_model(String gen_size_model) {
        this.gen_size_model = gen_size_model;
    }

    public String getInstall_status() {
        return install_status;
    }

    public void setInstall_status(String install_status) {
        this.install_status = install_status;
    }

    public String getCustomer_note() {
        return customer_note;
    }

    public void setCustomer_note(String customer_note) {
        this.customer_note = customer_note;
    }
}
