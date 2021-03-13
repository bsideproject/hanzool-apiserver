package com.sublink.api.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sublink.api.utils;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFavorite {

    String userId;
    List<Integer> genres = new ArrayList<>();
    List<String> keyWords = new ArrayList<>();
    List<Integer> contents = new ArrayList<>();

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
        return utils.toJsonString(this);
    }

    public String getUserId() {
        return userId;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public List<Integer> getContents() {
        return contents;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public void setContents(List<Integer> contents) {
        this.contents = contents;
    }
}
