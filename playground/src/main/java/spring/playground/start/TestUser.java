package spring.playground.start;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;

/**
 * TestUser
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class TestUser {

    @Id
    @GeneratedValue
    public Long id;
    @Field("user")
    public String user;
    @Field("password")
    public String password;

    private boolean active;

    public TestUser(String user, String password, boolean active){
        this.user = user;
        this.password = password;
        this.active = active;
    }

    public org.bson.Document toDocument() {
        return new org.bson.Document()
        .append("user", user)
        .append("password", password);
    }
}