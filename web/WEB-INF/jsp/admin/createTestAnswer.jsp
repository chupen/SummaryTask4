<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 17.06.2018
  Time: 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Добавление Ответа</title>
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
    <h2>Тест: ${sessionScope.testInfo.name}</h2>
    <h2>Вопрос: ${sessionScope.testQuestion.questionText}</h2>
    <form action="tryToAddAnswer" method="post">
        <div class="col-2">
            <input class="form-control" type="text" name="answer" placeholder="Ответ"/><br>
            <div class="radio">
                <label><input type="radio" name="correct" value="on">Правильно</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="correct" value="off">Неправильно</label>
            </div>
            <input class="btn btn-primary" type="submit" value="Сохранить">
        </div>
    </form>
    <a href="addQuestion">
        <button class="btn btn-primary" type="button">Создать вопрос</button>
    </a>
</div>
</body>
</html>
