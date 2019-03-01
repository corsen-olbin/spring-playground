package spring.playground.start;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TestNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "note")
public class TestNote {

    @Id
    public String Id;

    @Field("user")
    public String user;

    @Field("note")
    public String note;

    @Field("DateCreated")
    public LocalDateTime DateCreated;

    TestNote(String user, String note) {
        this.user = user;
        this.note = note;
    }

    TestNote() {
        
    }
    
}