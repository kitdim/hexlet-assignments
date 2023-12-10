@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if(page.getName() != null)
        Welcome, ${page.getName().toString()}
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <button type="submit" name="logout">Выйти</button>
        </form>
    @else
        <form action="${NamedRoutes.buildSessionPath()}">
            <button type="submit" name="logout">Войти</button>
        </form>
    @endif
`)
