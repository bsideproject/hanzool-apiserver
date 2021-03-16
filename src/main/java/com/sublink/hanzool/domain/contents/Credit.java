package com.sublink.hanzool.domain.contents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.hanzool.utils.Utils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Credit {
  int id;
  String name;
  String roleName;
  String profileImagePath;

  public static Credit parseJson(String input) {
    ObjectMapper objectMapper = new ObjectMapper();
    Credit ret = null;
    try {
      ret = objectMapper.readValue(input, Credit.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return ret;
  }

  @Override
  public String toString() {
    return Utils.toJsonString(this);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getProfileImagePath() {
    return profileImagePath;
  }

  public void setProfileImagePath(String profileImagePath) {
    this.profileImagePath = profileImagePath;
  }
}