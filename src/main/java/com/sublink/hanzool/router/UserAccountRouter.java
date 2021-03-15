package com.sublink.hanzool.router;

import com.sublink.hanzool.handler.UserAccountHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserAccountRouter {

  @Bean
  public RouterFunction<ServerResponse> routes(UserAccountHandler userAccountHandler) {
    return RouterFunctions.route()
    // @formatter:off
      .GET("/api/users", userAccountHandler::findAll)
      .GET("/api/users/{id}", userAccountHandler::findById)
      .POST("/api/users/signup", userAccountHandler::signup)
    // @formatter:on
        .build();
  }

}
