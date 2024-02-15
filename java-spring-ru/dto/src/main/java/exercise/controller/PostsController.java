package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> index() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(this::toPostDto)
                .toList();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO show(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + 100 + " not found"));
        return toPostDto(post);
    }


    private PostDTO toPostDto(Post post) {
        PostDTO postDTO = new PostDTO();
        List<CommentDTO> commentDTOS = new ArrayList<>();
        List<Comment> comments = commentRepository.findByPostId(post.getId());

        for (var comment : comments) {
            commentDTOS.add(toCommentDto(comment));
        }

        postDTO.setId(post.getId());
        postDTO.setBody(post.getBody());
        postDTO.setTitle(post.getTitle());
        postDTO.setComments(commentDTOS);

        return postDTO;
    }

    private CommentDTO toCommentDto(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setBody(comment.getBody());
        commentDTO.setId(comment.getId());

        return commentDTO;
    }
}
// END
