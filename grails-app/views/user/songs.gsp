<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Songs list</title>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <thead>
        <th>Name</th>
        <th>Tags</th>
        </thead>
        <tbody>
        <g:each in="${items}" var="song">
            <tr>
                <td>${song.name}</td>
                <td><g:link aciton="tags">Tags</g:link></td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>