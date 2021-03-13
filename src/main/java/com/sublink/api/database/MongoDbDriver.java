package com.sublink.api.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
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

import static com.mongodb.client.model.Filters.eq;

public class MongoDbDriver implements DatabaseDriver {

    public static void main(String[] args) {
        MongoDbDriver db = new MongoDbDriver();
        db.connectDB();
        UserAccount ua = new UserAccount();
        ua.setEmail("email");
        ua.setId("1");
        ua.setPassword("pass");

        db.writeUserAccount(ua);
        System.out.println(db.readUserAccountById("1"));

    }

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

    private boolean write(String db, String collection, Object input) {
        MongoCollection<Document> mc = getCollection(db, collection);
        Document dc = Document.parse(input.toString());
        InsertOneResult ret = mc.insertOne(dc);
        if (ret.getInsertedId().isNull()) {
            return false;
        }
        return true;
    }

    private String read(String db, String collection, Bson condition) {
        MongoCollection mc = getCollection(db, collection);
        ArrayList<String> list = new ArrayList<>();
        mc.find(condition).forEach(
                s -> list.add(((Document) s).toJson())
        );
        if (list.size() > 0) {
            return list.get(0);
        }
        return "";
    }

    @Override
    public boolean writeUserAccount(UserAccount ua) {
        return write("user", "UserAccount", ua);
    }

    @Override
    public boolean writeUserProfile(UserProfile up) {
        return write("user", "UserProfile", up);
    }

    @Override
    public boolean writeUserFavorite(UserFavorite uf) {
        return write("user", "UserFavorite", uf);
    }

    @Override
    public UserAccount readUserAccountById(String id) {
        Bson cond = eq("id", id);
        String ret = read("user", "UserAccount", cond);
        if (ret.equals("")) {
            return null;
        }
        return UserAccount.parseJson(ret);
    }

    @Override
    public UserFavorite readUserFavoriteByUserId(String id) {
        Bson cond = eq("userId", id);
        String ret = read("user", "UserFavorite", cond);
        if (ret.equals("")) {
            return null;
        }
        return UserFavorite.parseJson(ret);
    }

    @Override
    public UserProfile readUserProfileByUserId(String id) {
        Bson cond = eq("userId", id);
        String ret = read("user", "UserProfile", cond);
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
        return write("content", "Content", c);
    }

    @Override
    public boolean writeGenre(Genre g) {
        return write("content", "Genre", g);
    }

    @Override
    public boolean writeCredit(Credit c) {
        return write("content", "Credit", c);
    }

    @Override
    public Content readContentById(int id) {
        Bson cond = eq("id", id);
        String ret = read("content", "Content", cond);
        if (ret.equals("")) {
            return null;
        }
        return Content.parseJson(ret);
    }

    @Override
    public List<Content> readContentListByTitle(String title) {
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
        String ret = read("content", "Credit", cond);
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
