package com.sublink.api.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.api.domain.contents.Genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFavorite {
    public Map<Integer, Genre> genres = new HashMap(); //FIXME: check data type map or list
    public Map<Integer, String> keyWords = new HashMap<>();
    public List<Integer> videos = new ArrayList<>();

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

    public Map<Integer, Genre> getGenres() {
        return genres;
    }

    public Map<Integer, String> getKeyWords() {
        return keyWords;
    }

    public List<Integer> getVideos() {
        return videos;
    }

    public void setGenres(Map<Integer, Genre> genres) {
        this.genres = genres;
    }

    public void setKeyWords(Map<Integer, String> keyWords) {
        this.keyWords = keyWords;
    }
}
