@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage postPage

@template.layout.page(
content = @`
    @if(postPage != null)
        <p>${postPage.getPost().getName()}</p>
        <p>${postPage.getPost().getBody()}</p>
    @else
        <p>Empty</p>
    @endif
    <a href="${NamedRoutes.postsPath()}">All posts</a>
`)
