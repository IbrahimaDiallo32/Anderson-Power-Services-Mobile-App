package com.aps.restfulbackend.Entities;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="userId", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="userName", length = 255)
    private String userName;

    @Column(name="userPassword", length = 255)
    private String userPassword;

    @Column(name="userEmail", length = 255)
    private String userEmail;

    @Column(name="userPhone")
    private int userPhone;

    @Column(name="userFirstName", length = 255)
    private String userFirstName;

    @Column(name="userLastName", length = 255)
    private String userLastName;

    @Column(name="userCreatedAt")
    private Date userCreatedAt;

    public User(long userId, String userName, String userPassword, String userEmail, String userFirstName, String userLastName) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }


    public User() {

    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Date getUserCreatedAt() {
        return userCreatedAt;
    }

    public void setUserCreatedAt(Date userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }
}
