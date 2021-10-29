package com.zuk.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class User extends BaseEntity{

    //TODO uniq field
    private String firstName;
    private String lastName;
    private String username;
    private String accessToken;
    private Date expiresIn;


    public User(String firstName, String lastName, String username, String accessToken, Date expiresIn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }

    public User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
