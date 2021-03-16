package com.sublink.hanzool.domain.contents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.hanzool.utils.Utils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Genre {
  public int getId() {
    return id;
  }

  public Type getType() {
    return type;
  }

  public enum Type {
    ACTION("액션"), SF("SF");

    final private String genre;

    Type(String genre) {
      this.genre = genre;
    }

    @Override
    public String toString() {
      return genre;
    }
  }

  public int id;
  public Type type;

  public static Genre parseJson(String input) {
    ObjectMapper objectMapper = new ObjectMapper();
    Genre ret = null;
    try {
      ret = objectMapper.readValue(input, Genre.class);
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
