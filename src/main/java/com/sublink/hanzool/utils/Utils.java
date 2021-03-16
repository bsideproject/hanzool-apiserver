package com.sublink.hanzool.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
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
