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
}
