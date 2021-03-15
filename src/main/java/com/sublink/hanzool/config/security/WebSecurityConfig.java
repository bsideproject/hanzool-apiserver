package com.sublink.api.config.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

  //@formatter:off
  private static final String[] AUTH_WHITELIST = {
    "/api/**",
    "/v2/api-docs",
    "/swagger-resources/**",
    "/swagger-ui.html",
    "/webjars/**",
  };
  //@formatter:on

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //@formatter:off
    http.authorizeRequests()
        .antMatchers(AUTH_WHITELIST).permitAll()
        .antMatchers("/**/*").denyAll();
    //@formatter:on
  }
}
