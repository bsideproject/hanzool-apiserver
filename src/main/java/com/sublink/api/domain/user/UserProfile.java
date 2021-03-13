package com.sublink.api.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.api.utils;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {
    public String userId;
    public String email;
    public String nickName;
    public String profilePath;
    public ArrayList<String> subsList = new ArrayList<>(); // FIXME: create Subscribe service class
    public ArrayList<Integer> following = new ArrayList<>();
    public ArrayList<Integer> followers = new ArrayList<>();
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
        return utils.toJsonString(this);
    }

    public String getUserId() {
        return userId;
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

    public ArrayList<Integer> getFollowing() {
        return following;
    }

    public ArrayList<Integer> getFollowers() {
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

    public void setUserId(String userId) {
        this.userId = userId;
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

    public void setFollowing(ArrayList<Integer> following) {
        this.following = following;
    }

    public void setFollowers(ArrayList<Integer> followers) {
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