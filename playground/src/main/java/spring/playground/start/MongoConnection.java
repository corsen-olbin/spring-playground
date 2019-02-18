package spring.playground.start;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MongoConnection {
    public static void PostToMongo() {
        MongoClient mongoClient = new MongoClient();

        MongoDatabase testdb = mongoClient.getDatabase("test");
        MongoCollection<Document> testCollection = testdb.getCollection("test");

        TestUser user = new TestUser("corbin", "password");
        Document document = user.toDocument();
        testCollection.insertOne(document);

        mongoClient.close();
    }
}