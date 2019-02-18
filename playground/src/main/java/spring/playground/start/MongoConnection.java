package spring.playground.start;

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

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

    public static List<TestUser> GetAllUsers() {

        MongoClient mongo = new MongoClient();
        
        MongoTemplate mongoTemplate = new MongoTemplate(mongo, "test");
        

        List<TestUser> resultList = mongoTemplate.findAll(TestUser.class);

        
        
        return resultList;
    }
}