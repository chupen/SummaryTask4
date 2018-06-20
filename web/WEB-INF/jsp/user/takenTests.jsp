<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 16.06.2018
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Пройденные тесты</title>
</head>
<body>
<c:set var="counter" value="0" scope="page"/>
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
<h2>Пройденные тесты</h2>
<table class="table">
    <thread>
        <th scope="col">Оценка</th>
        <th scope="col">Пройден</th>
        <th scope="col">Дата и время прохождения</th>
        <th scope="col">Пользователь</th>
        <th scope="col">Тест</th>
    </thread>
    <c:forEach items="${takenTests}" var="takenTest">
        <tr>
            <td>${takenTest.mark}</td>
            <td>${takenTest.passed}</td>
            <td>${takenTest.dateOfTaking}</td>
            <td>${userLogin}</td>
            <td>${testInfoList.get(counter).name}</td>
            <c:set var="counter" value="${counter+1}" scope="page"/>
        </tr>
    </c:forEach>
</table>
</body>
</html>
