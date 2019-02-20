package spring.playground.start;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * TestNote
 */
@Data
@Document(collection = "note")
public class TestNote {

    @Id
    public String Id;

    @Field("user")
    public String User;

    @Field("note")
    public String Note;

    @Field("DateCreated")
    public Date DateCreated;
    
}