package spring.playground.start;

import org.bson.Document;

/**
 * TestUser
 */
public class TestUser extends Document{

    public String User;
    public String Password;

    public TestUser(String user, String password){
        User = user;
        Password = password;
    }

    public Document toDocument() {
        return new Document()
        .append("user", User)
        .append("password", Password);
    }
}