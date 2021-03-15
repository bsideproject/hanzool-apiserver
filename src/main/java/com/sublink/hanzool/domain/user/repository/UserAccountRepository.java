package com.sublink.hanzool.domain.user.repository;

import com.sublink.hanzool.domain.user.model.UserAccount;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends ReactiveMongoRepository<UserAccount, String> {
}
