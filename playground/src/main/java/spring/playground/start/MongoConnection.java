package spring.playground.start;

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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

    public static TestUser PostUser(TestUser user) {
        MongoClient mongo = new MongoClient();

        MongoTemplate mongoTemplate = new MongoTemplate(mongo, "test");

        mongoTemplate.save(user, "test");

        return user;
    }

    public static List<TestUser> GetAllUsers() {

        MongoClient mongo = new MongoClient();
        
        MongoTemplate mongoTemplate = new MongoTemplate(mongo, "test");
        

        List<TestUser> resultList = mongoTemplate.findAll(TestUser.class);

        
        
        return resultList;
    }

    public static TestUser GetUser(String id) {
        MongoClient mongo = new MongoClient();

        MongoTemplate mongoTemplate = new MongoTemplate(mongo, "test");
        ObjectId objId = new ObjectId(id);
        Query query = new Query().addCriteria(Criteria.where("_id").is(objId));
        return mongoTemplate.find(query, TestUser.class).get(0);

    }

    public static void UpdateUser(TestUser user) {
        MongoTemplate template = getTestTemplate();

        template.save(user);
    }

    private static MongoTemplate getTestTemplate() {
        MongoClient mongo = new MongoClient();

        return new MongoTemplate(mongo, "test");
    }
}