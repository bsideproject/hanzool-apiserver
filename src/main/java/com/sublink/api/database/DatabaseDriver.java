package com.sublink.api.database;

import com.sublink.api.domain.user.UserAccount;
import com.sublink.api.domain.user.UserFavorite;
import com.sublink.api.domain.user.UserProfile;

public interface DatabaseDriver {
    boolean WriteUserAccount(UserAccount ua);

    boolean WriteUserProfile(UserProfile up);

    boolean WriteUserFavorite(UserFavorite uf);

    UserAccount ReadUserAccount(String id);

    UserFavorite ReadUserFavorite(String id);

    UserProfile ReadUserProfile(String id);

    boolean UpdateUserAccount(UserAccount ua);

    boolean UpdateUserProfile(UserProfile up);

    boolean UpdateUserFavorite(UserFavorite uf);
}
