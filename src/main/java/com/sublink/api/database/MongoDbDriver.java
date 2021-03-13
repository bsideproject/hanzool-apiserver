package com.sublink.api.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.TextSearchOptions;
import com.sublink.api.domain.contents.Content;
import com.sublink.api.domain.contents.Credit;
import com.sublink.api.domain.contents.Genre;
import com.sublink.api.domain.user.UserAccount;
import com.sublink.api.domain.user.UserFavorite;
import com.sublink.api.domain.user.UserProfile;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class MongoDbDriver implements DatabaseDriver {

    private MongoClient mongoClient;

    @Override
    public boolean Initialize() {
        connectDB();
        return false;
    }

    private void connectDB() {
        String MongoDB_IP = "127.0.0.1";
        int MongoDB_PORT = 27017;
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder -> {
                                    builder.hosts(Arrays.asList(new ServerAddress(MongoDB_IP, MongoDB_PORT)));
                                }
                        )
                        .applyToConnectionPoolSettings(builder -> {
                                    builder.minSize(10)
                                            .maxSize(50);
                                }
                        )
                        .build());
        this.mongoClient = mongoClient;
    }

    private MongoCollection<Document> getCollection(String db, String collection) {
        return this.mongoClient.getDatabase(db).getCollection(collection);
    }

    private boolean write(MongoCollection<Document> collection, Bson key, Object input) {
        Document dc = Document.parse(input.toString());
        System.out.println(dc.toString());
        Document ret = collection.findOneAndReplace(key, dc,
                new FindOneAndReplaceOptions().upsert(true));
        if (ret != null || ret.isEmpty()) {
            return false;
        }
        return true;
    }

    private String read(MongoCollection collection, Bson condition) {
        ArrayList<String> list = new ArrayList<>();
        collection.find(condition).forEach(
                s -> list.add(((Document) s).toJson())
        );
        if (list.size() > 0) {
            return list.get(0);
        }
        return "";
    }

    private List<String> readList(MongoCollection collection, Bson condition) {
        ArrayList<String> list = new ArrayList<>();
        collection.find(condition).forEach(
                s -> list.add(((Document) s).toJson())

        );

        return list;
    }

    @Override
    public boolean writeUserAccount(UserAccount ua) {
        Bson key = eq("id", ua.getId());
        return write(getCollection("user", "UserAccount"), key, ua);
    }

    @Override
    public boolean writeUserProfile(UserProfile up) {
        Bson key = eq("userId", up.getUserId());
        return write(getCollection("user", "UserProfile"), key, up);
    }

    @Override
    public boolean writeUserFavorite(UserFavorite uf) {
        Bson key = eq("userId", uf.getUserId());
        return write(getCollection("user", "UserFavorite"), key, uf);
    }

    @Override
    public UserAccount readUserAccountById(String id) {
        Bson cond = eq("id", id);
        String ret = read(getCollection("user", "UserAccount"), cond);
        if (ret.equals("")) {
            return null;
        }
        return UserAccount.parseJson(ret);
    }

    @Override
    public UserFavorite readUserFavoriteByUserId(String id) {
        Bson cond = eq("userId", id);
        String ret = read(getCollection("user", "UserFavorite"), cond);
        if (ret.equals("")) {
            return null;
        }
        return UserFavorite.parseJson(ret);
    }

    @Override
    public UserProfile readUserProfileByUserId(String id) {
        Bson cond = eq("userId", id);
        String ret = read(getCollection("user", "UserProfile"), cond);
        if (ret.equals("")) {
            return null;
        }
        return UserProfile.parseJson(ret);
    }

    @Override
    public boolean updateUserAccount(UserAccount ua) {
        return false;
    }

    @Override
    public boolean updateUserProfile(UserProfile up) {
        return false;
    }

    @Override
    public boolean updateUserFavorite(UserFavorite uf) {
        return false;
    }

    @Override
    public boolean writeContent(Content c) {
        Bson key = eq("id", c.getId());
        return write(getCollection("content", "Content"), key, c);
    }

    @Override
    public boolean writeGenre(Genre g) {
        Bson key = eq("id", g.getId());
        return write(getCollection("content", "Genre"), key, g);
    }

    @Override
    public boolean writeCredit(Credit c) {
        Bson key = eq("id", c.getId());
        return write(getCollection("content", "Credit"), key, c);
    }

    @Override
    public Content readContentById(int id) {
        Bson cond = eq("id", id);
        String ret = read(getCollection("content", "Content"), cond);
        if (ret.equals("")) {
            return null;
        }
        return Content.parseJson(ret);
    }

    @Override
    public List<Content> readContentListByTitle(String title) {
        Bson cond = regex("title", ".*" + title + ".*");
        List<String> ret = readList(getCollection("content","Content"), cond);
        ArrayList<Content> contents = new ArrayList<>();
        ret.forEach(
                s -> contents.add(Content.parseJson(s))
        );
        return null;
    }

    @Override
    public List<Content> readContentListByGenreId(int gereId) {
        return null;
    }

    @Override
    public List<Content> readContentListByCreditName(String creditName) {
        return null;
    }

    @Override
    public Credit readCreditById(int id) {
        Bson cond = eq("id", id);
        String ret = read(getCollection("content", "Credit"), cond);
        if (ret.equals("")) {
            return null;
        }
        return Credit.parseJson(ret);
    }

    @Override
    public boolean updateContent(Content c) {
        return false;
    }

    @Override
    public boolean updateGenre(Genre g) {
        return false;
    }

    @Override
    public boolean updateCredit(Credit c) {
        return false;
    }
}
