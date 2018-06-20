<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 14.06.2018
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Тест</title>
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
    <h2>${requestScope.testInfo.getName()}</h2>
    <div>
        <div class="col-1">Сложность:</div>
        <div class="col-2">
            <input class="form-control" value="${requestScope.testInfo.getComplexity()}" readonly/><br>
        </div>
    </div>
    <div>
        <div class="col-1">Время(мин):</div>
        <div class="col-2">
            <input class="form-control" value="${requestScope.testInfo.getTime()}" readonly/><br>
        </div>
    </div>
    <div>
        <div class="col-1">Проходной балл:</div>
        <div class="col-2">
            <input class="form-control" value="${requestScope.testInfo.getPassMark()}" readonly/><br>
        </div>
    </div>
    <div>
        <div class="col-1">Предмет:</div>
        <div class="col-2">
            <input class="form-control" value="${requestScope.subject}" readonly/><br>
        </div>
    </div>
    <div>
        <div class="col-1">Автор:</div>
        <div class="col-2">
            <input class="form-control" value="${requestScope.author}" readonly/><br>
        </div>
    </div>
    <div>
        <a href="startTest">
            <c:set var="iterate" scope="session" value="-1"/>
            <c:set var="mark" scope="session" value="0"/>
            <c:set var="testInfoId" scope="session" value="${requestScope.testInfo.id}"/>
            <button class="btn btn-primary" type="button">Начать</button>
        </a>
    </div>
    <br>
    <div>
        <a href="indexUser">
            <button class="btn btn-primary" type="button">Назад</button>
        </a>
    </div>
</div>
</body>
</html>
