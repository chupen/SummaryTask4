<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 16.06.2018
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Управления пользователями</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="adminIndex">Главная</a></li>
        </ul>
    </div>
</nav>
<table class="table">
    <thead>
        <th scope="col">Логин</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Заблокирован</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </thead>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <th scope="row">${user.login}</th>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.blocked}</td>
            <td><a href="tryToChangeStatus?userLogin=${user.login}&block=1" class="badge badge-light">Заблокировать</a></td>
            <td><a href="tryToChangeStatus?userLogin=${user.login}&block=0" class="badge badge-light">Разблокировать</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
