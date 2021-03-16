package com.sublink.hanzool.domain.user.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.hanzool.domain.contents.Genre;

import com.sublink.hanzool.utils.Utils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFavorite {

  @Id
  private String id;
  List<Integer> genres = new ArrayList<>();
  List<String> keyWords = new ArrayList<>();
  List<Integer> contents = new ArrayList<>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Integer> getGenres() {
    return genres;
  }

  public void setGenres(List<Integer> genres) {
    this.genres = genres;
  }

  public List<String> getKeyWords() {
    return keyWords;
  }

  public void setKeyWords(List<String> keyWords) {
    this.keyWords = keyWords;
  }

  public List<Integer> getContents() {
    return contents;
  }

  public void setContents(List<Integer> contents) {
    this.contents = contents;
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
    return Utils.toJsonString(this);
  }
}
