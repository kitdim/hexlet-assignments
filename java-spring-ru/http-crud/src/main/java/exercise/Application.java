package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public ResponseEntity<?> index(@RequestParam(defaultValue = "5") int limit,
                                   @RequestParam(defaultValue = "1") int page) {
        var startIndex = (page - 1) * limit;
        var result = posts.subList(startIndex, startIndex + page);

        return ResponseEntity.ok()
                .header("X-Total-Count",  String.valueOf(result.size()))
                .header("suck", "hahaha")
                .body(result);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.status(HttpStatus.OK)
                .body(post);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        var maybePost =  posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (maybePost.isPresent()) {
            var post = maybePost.get();
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> update(@PathVariable String id,
                                       @RequestBody Post data) {
        var maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (maybePost.isPresent()) {
            var page = maybePost.get();
            page.setId(data.getId());
            page.setTitle(data.getTitle());
            page.setBody(data.getBody());
            return ResponseEntity.status(HttpStatus.OK).body(data);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }

    @GetMapping("/")
    public static String home() {
        return "Hello";
    }

    @GetMapping("/about")
    public static String about() {
        return "about";
    }

    @GetMapping("/hello")
    public static String sayHello(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/inspect")
    public static String inspect() {
        List<String> res = new ArrayList<>();
        for (var item : Post.class.getDeclaredMethods()) {
            String name = item.getName();
            String returnType = item.getReturnType().getTypeName();
            res.add("Method " + name + " returns a value of type " + returnType);
        }
        return res.toString();
    }
    // END
}
