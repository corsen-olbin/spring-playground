package spring.playground.start;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * PlaygroundController
 */
/* RestController annotation is combination of @Controller and 
    @ResponseBody */
@RestController
@RequestMapping("playground")
public class PlaygroundController {

    @PostMapping("/user")
    public ResponseEntity<Void> postUser(@RequestBody TestUser user) {
        TestUser testUser = MongoConnection.PostUser(user);

        if(testUser == null) 
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
            "/{id}").buildAndExpand(testUser.id).toUri();
        
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/user")
    public List<TestUser> getUsers() {
        return MongoConnection.GetAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity

    @PutMapping("/user")
    public ResponseEntity<Void> putUser(@RequestBody TestUser updatedUser) {
        TestUser user = MongoConnection.GetUser(updatedUser.id);

        if (user == null) {
            return ResponseEntity.notFound().build();    
        }    
        
        MongoConnection.UpdateUser(updatedUser);
        return ResponseEntity.ok().build();
        
    }

    
}