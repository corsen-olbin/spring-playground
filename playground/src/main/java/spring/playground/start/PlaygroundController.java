package spring.playground.start;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * PlaygroundController
 */
@Controller
public class PlaygroundController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/playground/user")
    public ResponseEntity<Void> postUser(@RequestBody TestUser user) {
        TestUser testUser = MongoConnection.PostUser(user);

        if(testUser == null) 
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
            "/{id}").buildAndExpand(testUser.id).toUri();
        
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/playground/user")
    @ResponseBody
    public List<TestUser> getUsers(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return MongoConnection.GetAllUsers();
    }

    
}