package com.sublink.hanzool.domain.user.model;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.hanzool.domain.contents.Genre;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserFavorite {

  @Id
  private String id;
  private Map<Integer, Genre> genres; // FIXME: check data type map or list
  private Map<Integer, String> keyWords;

  public Map<Integer, Genre> getGenres() {
    return genres;
  }

  public Map<Integer, String> getKeyWords() {
    return keyWords;
  }

  public static UserFavorite parseJson(String input) {
    ObjectMapper objectMapper = new ObjectMapper();
    UserFavorite ret = null;
    try {
      ret = objectMapper.readValue(input, UserFavorite.class);
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
}
