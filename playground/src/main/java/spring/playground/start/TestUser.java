package spring.playground.start;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * TestUser
 */
@Data
@Document(collection = "user")
public class TestUser {

    @Id
    public String id;
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