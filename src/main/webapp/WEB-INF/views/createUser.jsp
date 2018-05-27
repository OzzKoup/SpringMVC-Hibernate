<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user</title>
</head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<div class = "container">
    <h1>Enter your values to create new user</h1>
    <form method="post" action="/create">
        <div>
            <p> Name : </p>
            <input type="text" name="name" placeholder="Ivan">
            <p> Surname : </p>
            <input type="text" name="surname" placeholder="Ivanov">
            <p> Country : </p>
            <input type="text" name="country" placeholder="Poland">
            <p> Current E-mail : </p>
            <input type="text" name="email" placeholder="test@example.com"><br>
        </div>
        <input class="btn btn-success" type="submit" value="Create">
    </form>
</div>
</table>
</body>
</html>
