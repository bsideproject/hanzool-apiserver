package com.sublink.hanzool.domain.user.service;

import com.sublink.hanzool.domain.user.model.UserAccount;
import com.sublink.hanzool.domain.user.model.UserAccountDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserAccountService {
  Mono<UserAccount> save(UserAccountDto userAccount);
  Mono<UserAccount> findById(String id);
  Flux<UserAccount> findAll();
}
