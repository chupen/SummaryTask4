<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 15.06.2018
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Добавление вопросов</title>
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
    <h2>${testInfo.name}</h2><br>
    <form action="tryToAddQuestion" method="post">
        <div class="col-2">
            <input class="form-control" type="text" name="question" placeholder="Вопрос"/><br>
        </div>
        <input class="btn btn-primary" type="submit" value="Подтвердить">
    </form>
</div>
</body>
</html>
