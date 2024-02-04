package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> index() {
        return postRepository.findAll();
    }
    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post show(@PathVariable(name = "id") Long id) {
        return postRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }
    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post update(
            @PathVariable(name = "id") Long id,
            @RequestBody Post somePost) {
        Post post = postRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        post.setTitle(somePost.getTitle());
        post.setBody(somePost.getBody());

        postRepository.save(post);
        return post;
    }
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "id") Long id) {
        Post post = postRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        commentRepository.deleteByPostId(id);
        postRepository.delete(post);
    }
}
// END
