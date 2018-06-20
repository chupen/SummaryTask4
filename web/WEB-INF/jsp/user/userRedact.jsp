<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 14.06.2018
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Профиль</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="indexUser">Главная</a></li>
        </ul>
    </div>
</nav>
<div align="center">
    <form action="tryToRedactUser" method="post">
        <div>
            <h2>Профиль</h2>
            <div>
                <div class="col-1">Логин:</div>
                <div class="col-2">
                    <input class="form-control" type="text" name="login" minlength="3" maxlength="24"
                           value="${sessionScope.session_user.login}"/><br>
                </div>
            </div>
            <div>
                <div class="col-1">Почта:</div>
                <div class="col-2">
                    <input class="form-control" type="text" name="email" minlength="6" maxlength="50"
                           value="${sessionScope.session_user.email}"/><br>
                </div>
            </div>
            <div>
                <div class="col-1">Имя:</div>
                <div class="col-2">
                    <input class="form-control" type="text" name="name" minlength="2" maxlength="24"
                           value="${sessionScope.session_user.name}"/><br>
                </div>
            </div>
            <div>
                <div class="col-1">Фамилия:</div>
                <div class="col-2">
                    <input class="form-control" type="text" name="surname" minlength="2" maxlength="24"
                           value="${sessionScope.session_user.surname}"/><br>
                </div>
            </div>
            <div>
                <div class="col-1">Группа:</div>
                <div class="col-2">
                    <select class="form-control" name="group">
                        <c:forEach items="${requestScope.groups}" var="group">
                            <c:choose>
                                <c:when test="${session_user.groupId eq group.id}">
                                    <option value="${group.id}" selected="selected">${group.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${group.id}">${group.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <br>
            <div>
                <input type="submit" class="btn btn-primary" value="Сохранить"/>
            </div>
            <br>
            <div>
                <a href="indexUser">
                    <button class="btn btn-primary" type="button">Назад</button>
                </a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
