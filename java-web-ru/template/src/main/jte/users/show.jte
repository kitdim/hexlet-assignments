@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Список пользователей</title>
</head>
<body>
<h1>Список</h1>
@if (page.getUsers().isEmpty())
    <p>Пользователи не добавлены</p>
@else
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Email</th>
            <th scope="col">Link</th>
        </tr>
        </thead>
        <tbody>
        @for(var user : page.getUsers())
            <tr>
                <th>${user.getId()}</th>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
                <td><a href="users/${user.getId()}">link</a></td>
            </tr>
        @endfor
        </tbody>
    </table>
@endif
</body>
</html>
