@import exercise.dto.users.UserPage
@param UserPage page
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>${page.getUser().getFirstName()}</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <th>${page.getUser().getId()}</th>
            <td>${page.getUser().getFirstName()}</td>
            <td>${page.getUser().getLastName()}</td>
            <td>${page.getUser().getEmail()}</td>
        </tr>
    </tbody>
</table>
</body>
</html>
<!-- END -->
