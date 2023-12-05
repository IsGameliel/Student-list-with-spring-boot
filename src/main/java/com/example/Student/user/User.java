package com.example.Student.user;

import java.time.LocalDate;

public class User {
    private Long Id;
    private String Username;
    private String Email;
    private String PhoneNumber;
    private LocalDate DateCreated;
    private String status;

    public User() {
    }

    public User(Long id,
                String username,
                String email,
                String phoneNumber,
                LocalDate dateCreated,
                String status) {
        Id = id;
        Username = username;
        Email = email;
        PhoneNumber = phoneNumber;
        DateCreated = dateCreated;
        this.status = status;
    }

    public User(String username,
                String email,
                String phoneNumber,
                LocalDate dateCreated,
                String status) {
        Username = username;
        Email = email;
        PhoneNumber = phoneNumber;
        DateCreated = dateCreated;
        this.status = status;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public LocalDate getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        DateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Username='" + Username + '\'' +
                ", Email='" + Email + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", DateCreated=" + DateCreated +
                ", status='" + status + '\'' +
                '}';
    }
}
