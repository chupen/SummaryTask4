<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 15.06.2018
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Редактирование теста</title>
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
    <h2>Редактирование</h2>
    <form action="tryToRedactTestInfo" method="post">
        <input type="hidden" name="id" value="${requestScope.testInfo.id}">
        <div class="col-1">Название:</div>
        <div class="col-2">
            <input class="form-control" type="text" name="name" minlength="3" maxlength="24"
                   value="${requestScope.testInfo.name}"/>
        </div>
        <br>
        <div>
            <label for="cmplxt">Сложность:</label>
            <div class="col-2">
                <select class="form-control" id="cmplxt" name="complexity">
                    <c:choose>
                        <c:when test="${requestScope.testInfo.complexity eq 'EASY'}">
                            <option name="easy" value="EASY" selected="selected">Легко</option>
                        </c:when>
                        <c:otherwise>
                            <option name="easy" value="EASY">Легко</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${requestScope.testInfo.complexity eq 'MEDIUM'}">
                            <option name="medium" value="MEDIUM" selected="selected">Средне</option>
                        </c:when>
                        <c:otherwise>
                            <option name="medium" value="MEDIUM">Средне</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${requestScope.testInfo.complexity eq 'HARD'}">
                            <option name="hard" value="HARD" selected="selected">Сложно</option>
                        </c:when>
                        <c:otherwise>
                            <option name="hard" value="HARD">Сложно</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>
        <br>
        <div>
            <div class="col-1">Время(мин):</div>
            <div class="col-2">
                <input class="form-control" type="number" name="time" minlength="1" maxlength="24"
                       value="${requestScope.testInfo.time}"/>
            </div>
        </div>
        <div>
            <div class="col-1">Проходной балл:</div>
            <div class="col-2">
                <input class="form-control" type="number" name="passMark" minlength="1" maxlength="5"
                       value="${requestScope.testInfo.passMark}"/></div>
        </div>
        <div>
            <div class="col-1">Предмет id</div>
            <div class="col-2">
                <select class="form-control" name="subject">
                    <c:forEach var="subject" items="${subjects}">
                        <c:choose>
                            <c:when test="${subject.id == testInfo.subjectId}">
                                <option value="${subject.id}" selected="selected">${subject.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${subject.id}">${subject.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div>
            <div class="col-1">Автор</div>
            <div class="col-2">
                <input class="form-control" type="text" name="author"
                       value="${requestScope.author}" readonly/></div>
        </div>
        <br>
        <input type="submit" class="btn btn-primary" value="Подтвердить"/>
    </form>

    <form action="tryToDeleteTestInfo" method="post">
        <input type="hidden" name="id" value="${requestScope.testInfo.id}"/>
        <input class="btn btn-primary" type="submit" value="Удалить"/>
    </form>
    <a href="testQuestionRedact">
        <c:set var="testInfo" scope="session" value="${requestScope.testInfo}"/>
        <c:set var="iterate" scope="session" value="0"/>
        <input class="btn btn-primary" type="submit" value="Редактировать вопросы"/>
    </a>
    <a href="addQuestion">
        <c:set var="testInfo" scope="session" value="${requestScope.testInfo}"/>
        <button class="btn btn-primary" type="button">Добавить вопрос</button>
    </a>
</div>
</body>
</html>
