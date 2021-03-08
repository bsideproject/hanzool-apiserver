package com.sublink.api.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.sublink.api.domain.user.UserAccount;
import com.sublink.api.domain.user.UserFavorite;
import com.sublink.api.domain.user.UserProfile;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

public class MongoDbDriver implements DatabaseDriver {

    public static void main(String[] args) {
        MongoDbDriver db = new MongoDbDriver();
        db.connectDB();
        UserAccount ua = new UserAccount();
        ua.setEmail("email");
        ua.setId("1");
        ua.setPassword("pass");

        db.WriteUserAccount(ua);
        System.out.println(db.ReadUserAccount("1"));

    }

    MongoClient mongoClient;

    public void connectDB() {
        String MongoDB_IP = "127.0.0.1";
        int MongoDB_PORT = 27017;
        String DB_NAME = "testDB";

        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress(MongoDB_IP, MongoDB_PORT))))
                        .build());
        this.mongoClient = mongoClient;
    }

    @Override
    public boolean WriteUserAccount(UserAccount ua) {
        MongoDatabase md = this.mongoClient.getDatabase("user");
        MongoCollection<Document> mc = md.getCollection("UserAccount");
        Document dc = Document.parse(ua.toString());
        InsertOneResult ret = mc.insertOne(dc);
        if (ret.getInsertedId().isNull()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean WriteUserProfile(UserProfile up) {
        MongoDatabase md = this.mongoClient.getDatabase("user");
        MongoCollection<Document> mc = md.getCollection("UserProfile");
        Document dc = Document.parse(up.toString());
        InsertOneResult ret = mc.insertOne(dc);
        if (ret.getInsertedId().isNull()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean WriteUserFavorite(UserFavorite uf) {
        MongoDatabase md = this.mongoClient.getDatabase("user");
        MongoCollection<Document> mc = md.getCollection("UserFavorite");
        Document dc = Document.parse(uf.toString());
        InsertOneResult ret = mc.insertOne(dc);
        if (ret.getInsertedId().isNull()) {
            return false;
        }
        return true;
    }

    @Override
    public UserAccount ReadUserAccount(String id) {
        MongoDatabase md = this.mongoClient.getDatabase("user");
        MongoCollection<Document> mc = md.getCollection("UserAccount");
        ArrayList<String> list = new ArrayList<>();
        mc.find(eq("id", id)).forEach(
                s -> list.add(s.toJson())
        );
        return UserAccount.parseJson(list.get(0));
    }

    @Override
    public UserFavorite ReadUserFavorite(String id) {
        MongoDatabase md = this.mongoClient.getDatabase("user");
        MongoCollection<Document> mc = md.getCollection("UserFavorite");
        ArrayList<String> list = new ArrayList<>();
        mc.find(eq("id", id)).forEach(
                s -> list.add(s.toJson())
        );
        return UserFavorite.parseJson(list.get(0));
    }

    @Override
    public UserProfile ReadUserProfile(String id) {
        MongoDatabase md = this.mongoClient.getDatabase("user");
        MongoCollection<Document> mc = md.getCollection("UserProfile");
        ArrayList<String> list = new ArrayList<>();
        mc.find(eq("id", id)).forEach(
                s->list.add(s.toJson())
        );
        return UserProfile.parseJson(list.get(0));
    }

    @Override
    public boolean UpdateUserAccount(UserAccount ua) {
        return false;
    }

    @Override
    public boolean UpdateUserProfile(UserProfile up) {
        return false;
    }

    @Override
    public boolean UpdateUserFavorite(UserFavorite uf) {
        return false;
    }
}
