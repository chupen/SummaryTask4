<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 15.06.2018
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Добавление теста</title>
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
<div align="center">
    <h2>Создание теста</h2>
    <form action="tryToCreateTestInfo" method="post">
        <div>
            <div class="col-1">Название:</div>
            <div class="col-2">
                <input class="form-control" type="text" name="name" minlength="3" maxlength="24"
                       placeholder="Название Теста"/>
            </div>
        </div>
        <br>
        <div>
            <label for="cmplxt">Сложность:</label>
            <div class="col-2">
                <select class="form-control" id="cmplxt" name="complexity">
                    <option name="easy" value="EASY">Легко</option>
                    <option name="medium" value="MEDIUM">Средне</option>
                    <option name="hard" value="HARD">Сложно</option>
                </select>
            </div>
        </div>
        <br>
        <div>
            <div class="col-1">Время(мин):</div>
            <div class="col-2">
                <input class="form-control" type="text" name="time" minlength="1" maxlength="10"
                       placeholder="Время (мин)"/>
            </div>
        </div>
        <div>
            <div class="col-1">Проходной балл:</div>
            <div class="col-2">
                <input class="form-control" type="text" name="passMark" minlength="1" maxlength="5"
                       placeholder="Проходной балл"/>
            </div>
        </div>
        <div>
            <div class="col-1">Предмет:</div>
            <div class="col-2">
                <select class="form-control" name="subject">
                    <c:forEach var="subject" items="${subjects}">
                                <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <br>
        <input class="btn btn-primary" type="submit" value="Подвердить"/>
    </form>
</div>
</body>
</html>
