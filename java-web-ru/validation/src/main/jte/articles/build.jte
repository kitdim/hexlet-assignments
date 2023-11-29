@import exercise.dto.articles.NewArticlePage
@param NewArticlePage page

@template.layout.page(
content = @`
@if(page.getErrors() != null)
    <ul>
        @for(var validator: page.getErrors().values())
            @for(var error: validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

    <form action="/articles" method="post">
        <div class="mb-3">
            <label class="form-label">Title</label>
            <input type="text" class="form-control" name="title">
        </div>
        <label class="form-label">Content</label>
        <div class="form-floating">
            <textarea class="form-control" id="floatingTextarea2" style="height: 100px" name="content"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
`)