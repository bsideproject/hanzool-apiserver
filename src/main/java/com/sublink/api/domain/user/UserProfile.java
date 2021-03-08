package com.sublink.api.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {
    public int id;
    public String email;
    public String nickName;
    public String profilePath;
    public ArrayList<String> subsList = new ArrayList<>(); // FIXME: create Subscribe service class
    public ArrayList<UserProfile> following = new ArrayList<>(); // FIXME: check type map or list
    public ArrayList<UserProfile> followers = new ArrayList<>();
    public UserFavorite favorite;
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

    public Date getRegistered() {
        return registered;
    }

    public Date getExpired() {
        return expired;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public void setSubsList(ArrayList<String> subsList) {
        this.subsList = subsList;
    }

    public void setFollowing(ArrayList<UserProfile> following) {
        this.following = following;
    }

    public void setFollowers(ArrayList<UserProfile> followers) {
        this.followers = followers;
    }

    public void setFavorite(UserFavorite favorite) {
        this.favorite = favorite;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }
}