package com.sublink.api.persistent;

import com.sublink.api.domain.user.UserAccount;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserAccount, Long> {
  // TODO: make interfaces
}
