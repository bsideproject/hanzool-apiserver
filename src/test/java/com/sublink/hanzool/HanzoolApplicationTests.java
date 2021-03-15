package com.sublink.hanzool;

import com.sublink.hanzool.HanzoolApplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { HanzoolApplication.class })
class HanzoolApplicationTests {

  @Value("${spring.profiles.active}")
  private String profile;

  @Test
  void contextLoads() {
    Assertions.assertEquals("dev", profile);
  }

}
