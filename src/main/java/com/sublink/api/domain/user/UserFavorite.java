package com.sublink.api.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.api.domain.contents.Genre;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFavorite {
    public List<Genre> genres = new ArrayList<>();
    public List<String> keyWords = new ArrayList<>();
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

    public List<Genre> getGenres() {
        return genres;
    }

    public List<String> getKeyWords() {
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
