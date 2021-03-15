package com.sublink.hanzool.domain.user.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserProfile {

  @Id
  private int id;
  private String email;
  private String nickName;
  private String profilePath;
  private List<String> subsList; // FIXME: create Subscribe service class
  private List<UserProfile> following; // FIXME: check type map or list
  private List<UserProfile> followers;
  private UserFavorite favorite;
  private boolean mania;
  private Date registered;
  private Date expired;

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

  public List<String> getSubsList() {
    return subsList;
  }

  public List<UserProfile> getFollowing() {
    return following;
  }

  public List<UserProfile> getFollowers() {
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
