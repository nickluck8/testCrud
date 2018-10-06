package com.simpleRest.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.simpleRest.model.enums.Role;

public class UserDto {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("secondName")
    private String secondName;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("role")
    private Role role;

    public UserDto() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
