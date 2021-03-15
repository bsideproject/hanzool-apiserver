package com.sublink.hanzool.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {

  //@formatter:off
  // private static final String[] AUTH_WHITELIST = {
  //   "/api/**",
  //   "/v2/api-docs",
  //   "/swagger-resources/**",
  //   "/swagger-ui.html",
  //   "/webjars/**",
  // };
  //@formatter:on

  @Bean
  public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
    // @formatter:off
    return http
      .authorizeExchange()
      .pathMatchers("/actuator/**").permitAll()
      .anyExchange().permitAll() //.authenticated()
      .and()
      .csrf().disable()
      .build();
    // @formatter:on
  }

}
