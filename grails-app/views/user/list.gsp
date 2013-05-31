<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Users list</title>
</head>
<body>
    <div class="container">
        <table class="table table-striped">
            <thead>
            <th>Username</th>
            <th>Nickname</th>
            <th>Songs</th>
            </thead>
            <tbody>
            <g:each in="${items}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.nickname}</td>
                <td><g:link aciton="songs">Songs</g:link></td>
            </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</body>
</html>