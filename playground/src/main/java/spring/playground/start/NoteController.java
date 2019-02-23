package spring.playground.start;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NoteController
 */
@RestController
@RequestMapping("playground")
public class NoteController {

    @PostMapping("/note")
    public ResponseEntity<Void> PostNote(TestNote note){
        TestNote inserted = MongoConnection.PostNote(note);


    }
}