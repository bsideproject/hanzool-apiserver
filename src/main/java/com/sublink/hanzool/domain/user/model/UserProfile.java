package com.sublink.api.domain.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;

public class UserProfile {
    public int id;
    public String email;
    public String nickName;
    public String profilePath;
    public ArrayList<String> subsList = new ArrayList<>(); // FIXME: create Subscribe service class
    public ArrayList<UserProfile> following = new ArrayList<>(); // FIXME: check type map or list
    public ArrayList<UserProfile> followers = new ArrayList<>();
    public UserFavorite favorite;
    public boolean mania;
    public Date registered;
    public Date expired;

    public static UserProfile parseJson(String input) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserProfile ret = null;
        try {
            ret = objectMapper.readValue(input, UserProfile.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        String ret = "";
        try {
            ret = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public int getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public ArrayList<String> getSubsList() {
        return subsList;
    }

    public ArrayList<UserProfile> getFollowing() {
        return following;
    }

    public ArrayList<UserProfile> getFollowers() {
        return followers;
    }

    public UserFavorite getFavorite() {
        return favorite;
    }

    public boolean isMania() {
        return mania;
    }

    public Date getRegistered() {
        return registered;
    }

    public Date getExpired() {
        return expired;
    }
}