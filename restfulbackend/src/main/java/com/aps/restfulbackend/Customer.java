package com.aps.restfulbackend;

import jakarta.persistence.*;

//import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String email;

    // Constructors, Getters, Setters
    public Customer() {}

    public Customer(String firstName, String lastName, String email) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }
    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }
    public void setLastName(String lastName) {
        this.last_name = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
