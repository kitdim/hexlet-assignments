package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {
    // BEGIN
    public static void index(Context ctx) {
        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
        if (page < 1) {
            page = 1;
        } else if (page > 6) {
            page = 6;
        }
        var offset = (page - 1) * per;
        List<Post> sliceOfPosts = PostRepository.getEntities().subList(offset, offset + per);
        var postsPage = new PostsPage(sliceOfPosts, page);
        ctx.render("posts/index.jte", Collections.singletonMap("postsPage", postsPage));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class)
                .get();
        var post = PostRepository.find(id);
        if (post.isEmpty()) {
            throw new NotFoundResponse("Page not found");
        }
        var page = new PostPage(post.get());
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
