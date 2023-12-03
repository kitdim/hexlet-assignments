@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage postsPage

@template.layout.page(
content = @`
    <ul class="list-unstyled">
        <li>Posts:
            <ul>
                @for(var post: postsPage.getPosts())
                    <li>
                        <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                    </li>
                @endfor
            </ul>
        </li>
    </ul>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link"
                   href="${NamedRoutes.postsPath()}?page=${postsPage.getPage() - 1}">Previous</a>
            </li>
            <li class="page-item">
                <a class="page-link"
                   href="${NamedRoutes.postsPath()}?page=${postsPage.getPage() + 1}">Next</a>
            </li>
        </ul>
    </nav>
`
)
