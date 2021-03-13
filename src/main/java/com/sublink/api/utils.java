package com.sublink.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class utils {
    public static String toJsonString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String ret = "";
        try {
            ret = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
