package com.sublink.api.database;

import com.sublink.api.domain.contents.Content;
import com.sublink.api.domain.contents.Credit;
import com.sublink.api.domain.contents.Genre;

import java.util.List;

public interface ContentDB {
    boolean writeContent(Content c);

    boolean writeGenre(Genre g);

    boolean writeCredit(Credit c);

    Content readContentById(int id);

    List<Content> readContentListByTitle(String title);

    List<Content> readContentListByGenreId(int gereId);

    List<Content> readContentListByCreditName(String creditName);

    Credit readCreditById(int id);

    boolean updateContent(Content c);

    boolean updateGenre(Genre g);

    boolean updateCredit(Credit c);
}
