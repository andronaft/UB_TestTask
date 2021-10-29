package com.zuk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zuk.model.User;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UBsendAuthDto {
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String accessToken;
    private Date expiresIn;

    public UBsendAuthDto fromUser(User user){
        email = user.getUsername();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        username = user.getUsername();
        accessToken = user.getAccessToken();
        expiresIn = user.getExpiresIn();
        return this;
    }
}
