package com.sublink.api.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.api.utils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccount {
    String id;
    String password; // todo: should encode
    String email;

    public static UserAccount parseJson(String input) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserAccount ret = null;
        try {
            ret = objectMapper.readValue(input, UserAccount.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public String toString() {
        return utils.toJsonString(this);
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
