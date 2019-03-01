package spring.playground.start;

import java.util.List;

import com.mongodb.MongoClient;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class MongoConnection {

    public static TestUser PostUser(TestUser user) {
        MongoClient mongo = new MongoClient();

        MongoTemplate mongoTemplate = new MongoTemplate(mongo, "test");
        mongoTemplate.save(user, "user");

        return user;
    }

    public static List<TestUser> GetAllUsers() {

        MongoClient mongo = new MongoClient();
        
        MongoTemplate mongoTemplate = new MongoTemplate(mongo, "test");
        

        List<TestUser> resultList = mongoTemplate.findAll(TestUser.class);

        
        
        return resultList;
    }

    public static TestUser GetUser(String user) {
        MongoClient mongo = new MongoClient();

        MongoTemplate mongoTemplate = new MongoTemplate(mongo, "test");
        ObjectId objId = new ObjectId(user);
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

	public static TestNote PostNote(TestNote note) {
        MongoTemplate mongo = getTestTemplate();
        
        mongo.save(note, "note");

        return note;
	}
}