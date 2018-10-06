package com.simpleRest.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simpleRest.model.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String secondName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "role")
    private Role role;

    public User() {
    }

    public User(String firstName, String secondName, String username, Role role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
