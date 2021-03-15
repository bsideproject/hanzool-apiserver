package com.sublink.hanzool.handler;

import com.sublink.hanzool.domain.user.model.UserAccount;
import com.sublink.hanzool.domain.user.model.UserAccountDto;
import com.sublink.hanzool.domain.user.service.UserAccountService;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.swagger.annotations.Api;
import reactor.core.publisher.Mono;

@Api(tags = "user")
@Component
public class UserAccountHandler {

  private final UserAccountService userAccountService;

  public UserAccountHandler(final UserAccountService userAccountService) {
    this.userAccountService = userAccountService;
  }

  public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userAccountService.findAll(),
        UserAccount.class);
  }

  public Mono<ServerResponse> findById(ServerRequest serverRequest) {
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
        .body(userAccountService.findById(serverRequest.pathVariable("id")), UserAccount.class);
  }

  public Mono<ServerResponse> signup(ServerRequest serverRequest) {
    return serverRequest.bodyToMono(UserAccountDto.class).flatMap(user -> ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON).body(userAccountService.save(user), UserAccount.class));
  }

}
