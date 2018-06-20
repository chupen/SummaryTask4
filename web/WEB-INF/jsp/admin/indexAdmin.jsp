<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 14.06.2018
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Управление</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="userManage">Управление пользователями</a></li>
            <li class="nav-item"><a class="nav-link" href="createTestInfo">Добавить тест</a></li>
            <li class="nav-item"><a class="nav-link" href="logout">Выход</a></li>
        </ul>
    </div>
</nav>
<form action="adminIndex">
    <br>
    <div class="container">
        <div class="row">
            <div class="col-2">
                <label for="select">Выборка по предмету:</label>
            </div>
            <div class="col-2">
                <select class="form-control" id="select" name="subject">
                    <option value="*">All</option>
                    <c:forEach items="${requestScope.subjects}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col">
                <label for="input1">Сортировать по имени:</label>
                <input id="input1" type="checkbox" name="name" value="sortByName">
            </div>
            <div class="col">
                <label for="input">Сортировать по сложности:</label>
                <input id="input" type="checkbox" name="complexity" value="sortByComplexity">
            </div>
            <div class="col">
                <button type="submit" class="btn btn-light">Применить</button>
            </div>
        </div>
    </div>
</form>
<table class="table">
    <thread>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Сложность</th>
            <th scope="col"></th>
        </tr>
    </thread>
    <tbody>
    <c:forEach items="${requestScope.testInfos}" var="testInfo">
        <tr>
            <th scope="row">${testInfo.name} </th>
            <td>${testInfo.complexity}</td>
            <td>
                <a href="testRedact?testInfoId=${testInfo.getId()}" class="badge badge-light">Редактировать</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
