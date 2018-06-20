<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 16.06.2018
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="web/css/index.css">
    <title>Редактирование вопросов</title>
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
<div class="row">
    <div class="col-1"></div>
    <div class="col">
        <br>
        <form action="tryToRedactTestQuestion" method="post">
            <div class="row">
                <input type="hidden" name="testQuestionId" value="${testQuestion.id}">
                <div class="col-1"><h2>Вопрос</h2></div>
                <div class="col-2">
                    <input class="form-control" type="text" name="testQuestionText"
                           value="${testQuestion.questionText}"/>
                </div>
            </div>
            <br>
            <c:forEach items="${requestScope.completeTests}" var="answer">
                <div class="row">
                    <div class="col-1">Ответ:</div>
                    <div class="col-2"><input class="form-control" type="text" name="answerText"
                                              value="${answer.getAnswerText()}"/></div>
                    <div class="col-1">Правда:</div>
                    <div class="col-3">
                        <c:if test="${answer.correct ne 0}">
                            <select class="form-control" name="correct">
                                <option value="1" selected="selected">Да</option>
                                <option value="0">Нет</option>
                            </select>
                        </c:if>
                        <c:if test="${answer.correct eq 0}">
                            <select class="form-control" name="correct">
                                <option value="1">Да</option>
                                <option value="0" selected="selected">Нет</option>
                            </select>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
            <br>
            <div class="row">
                <c:if test="${iterate ne '0'}">
                    <div class="col-1">
                        <input class="btn btn-primary" name="back" type="submit" value="Назад">
                    </div>
                </c:if>
                <div class="col-2">
                    <a href="addAnswer">
                        <button class="btn btn-primary" type="button">Добвавить ответ</button>
                    </a>
                </div>
                <div class="col-1">
                    <input class="btn btn-primary" type="submit" value="Вперед">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
