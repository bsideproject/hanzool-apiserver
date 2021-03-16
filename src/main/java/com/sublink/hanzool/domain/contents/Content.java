package com.sublink.hanzool.domain.contents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.hanzool.utils.Utils;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
  int id;
  String title;
  String overview;
  String posterPath;
  List<Integer> genres = new ArrayList<>();
  List<Credit> Credits = new ArrayList<>();

  public static Content parseJson(String input) {
    ObjectMapper objectMapper = new ObjectMapper();
    Content ret = null;
    try {
      ret = objectMapper.readValue(input, Content.class);
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getPosterPath() {
    return posterPath;
  }

  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  public List<Integer> getGenres() {
    return genres;
  }

  public void setGenres(List<Integer> genres) {
    this.genres = genres;
  }

  public List<Credit> getCredits() {
    return Credits;
  }

  public void setCredits(List<Credit> credits) {
    Credits = credits;
  }
}