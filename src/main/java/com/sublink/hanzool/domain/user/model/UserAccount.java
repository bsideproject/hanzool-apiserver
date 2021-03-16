package com.sublink.hanzool.domain.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sublink.hanzool.utils.Utils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccount {

  @Id
  private String id;
  private String email;
  private String username;
  private String password;

  @PersistenceConstructor
  public UserAccount(String id, String email, String username, String password) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return Utils.toJsonString(this);
  }
}
