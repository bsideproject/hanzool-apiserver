package com.sublink.hanzool.domain.user.service;

import com.sublink.hanzool.domain.user.model.UserAccount;
import com.sublink.hanzool.domain.user.model.UserAccountDto;
import com.sublink.hanzool.domain.user.repository.UserAccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserAccountServiceImpl implements UserAccountService {

  Logger log = LoggerFactory.getLogger(UserAccountServiceImpl.class);

  private final UserAccountRepository userAccountRepository;

  public UserAccountServiceImpl(final UserAccountRepository userAccountRepository) {
    this.userAccountRepository = userAccountRepository;
  }

  @Override
  public Mono<UserAccount> save(UserAccountDto user) {
    log.debug("user: {}", user);
    return userAccountRepository.save(user.toEntity());
  }

  // @PreAuthorize("hasRole('USER')")
  @Override
  public Mono<UserAccount> findById(String id) {
    log.debug("userId: {}", id);
    return userAccountRepository.findById(id);
  }

  // @PreAuthorize("hasRole('ADMIN')")
  @Override
  public Flux<UserAccount> findAll() {
    return userAccountRepository.findAll();
  }
}
