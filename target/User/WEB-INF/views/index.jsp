<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        p {
            font-weight: bold;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th> Id</th>
            <th> Name</th>
            <th> Surname</th>
            <th> Country</th>
            <th> E-mail</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <th>${user.id}</th>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.country}</td>
                <td>${user.email}</td>
                <td>
                    <form method="post" action="/delete">
                        <input type="hidden" name="delete" value="${user.id}">
                        <input class="btn btn-danger" type="submit" value="Delete">
                    </form>
                    <form method="post" action="/">
                        <input type="hidden" name="userId" value="${user.id}">
                        <input class="btn btn-warning" type="submit" value="Edit">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div style="float: right">
        <form method="get" action="/create">
            <input class="btn btn-success" type="submit" value="Create">
        </form>
    </div>
    <div style="visibility: hidden">
        <form style="visibility: ${visible}" method="post" action="/update">
            <p> Name : </p>
            <input type="text" name="name" value="${updateUser.name}">
            <p> Surname : </p>
            <input type="text" name="surname" value="${updateUser.surname}">
            <p> Country : </p>
            <input type="text" name="country" value="${updateUser.country}">
            <p> Email : </p>
            <input type="text" name="email" value="${updateUser.email}">
            <input type="hidden" name="id" value="${updateUser.id}"><br>
            <input class="btn btn-success" type="submit" value="Update">
        </form>
        </table>
    </div>
</div>
</body>
</html>
