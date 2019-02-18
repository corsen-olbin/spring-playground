package spring.playground.start;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PlaygroundController
 */
@Controller
public class PlaygroundController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/playground/user")
    @ResponseBody
    public List<TestUser> getUsers(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return MongoConnection.GetAllUsers();
    }

    @GetMapping("/")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}