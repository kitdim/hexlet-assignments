@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    @if(page != null)
        <p>${page.getPost().getName()}</p>
        <p>${page.getPost().getBody()}</p>
    @else
        <p>Empty</p>
    @endif
    <a href="${NamedRoutes.postsPath()}">All posts</a>
`)
