package exercise.controller;

import exercise.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping(path = "/comments")
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> index() {
        return commentRepository.findAll();
    }
    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment show(@PathVariable(name = "id") Long id) {
        return commentRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
    }
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }
    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment update(
            @PathVariable(name = "id") Long id,
            @RequestBody Comment someComment) {
        Comment comment = commentRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        comment.setBody(someComment.getBody());
        comment.setPostId(someComment.getPostId());

        commentRepository.save(comment);
        return comment;
    }
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "id") Long id) {
        Comment comment = commentRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        commentRepository.delete(comment);
    }
}
// END
