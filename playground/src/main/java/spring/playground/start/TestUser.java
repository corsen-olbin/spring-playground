package spring.playground.start;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * TestUser
 */
@Document(collection = "test")
public class TestUser {

    @Id
    private String id;
    @Field("user")
    public String user;
    @Field("password")
    public String password;

    public TestUser(String user, String password){
        this.user = user;
        this.password = password;
    }

    public org.bson.Document toDocument() {
        return new org.bson.Document()
        .append("user", user)
        .append("password", password);
    }
}