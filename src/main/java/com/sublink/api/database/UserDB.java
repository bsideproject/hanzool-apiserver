package com.sublink.api.database;

import com.sublink.api.domain.user.UserAccount;
import com.sublink.api.domain.user.UserFavorite;
import com.sublink.api.domain.user.UserProfile;

public interface UserDB {
    boolean writeUserAccount(UserAccount ua);

    boolean writeUserProfile(UserProfile up);

    boolean writeUserFavorite(UserFavorite uf);

    UserAccount readUserAccountById(String id);

    UserFavorite readUserFavoriteByUserId(String id);

    UserProfile readUserProfileByUserId(String id);

    boolean updateUserAccount(UserAccount ua);

    boolean updateUserProfile(UserProfile up);

    boolean updateUserFavorite(UserFavorite uf);
}
