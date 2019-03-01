package spring.playground.start;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NoteController
 */
@RestController
@RequestMapping("playground")
public class NoteController {

    @PostMapping("/note")
    public ResponseEntity<TestNote> PostNote(@RequestBody TestNote note){
        note.DateCreated = LocalDateTime.now();
        TestNote inserted = MongoConnection.PostNote(note);
        return new ResponseEntity<TestNote>(inserted, HttpStatus.OK);

    }
}