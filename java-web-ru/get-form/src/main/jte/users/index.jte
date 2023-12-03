@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<form action="/users" method="get">
    <div class="col-md-6">
        <input type="search" name="term" value="${page.getTerm()}">
        <input type="submit" value="Search">
    </div>
</form>
<table class="table table-dark table-striped">
    <thead>
        <tr>
            <th scope="col">First name</th>
            <th scope="col">Last name</th>
            <th scope="col">email</th>
        </tr>
    </thead>
    <tbody>
    @for(var user: page.getUsers())
    <tr>
        <td>${user.getFirstName()}</td>
        <td>${user.getLastName()}</td>
        <td>${user.getEmail()}</td>
    </tr>
    @endfor
    </tbody>
</table>
</body>
</html>
