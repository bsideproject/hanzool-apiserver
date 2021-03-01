package com.sublink.api;

import com.sublink.api.domain.contents.Genre;
import com.sublink.api.domain.user.UserFavorite;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class SublinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SublinkApplication.class, args);
	}

}
