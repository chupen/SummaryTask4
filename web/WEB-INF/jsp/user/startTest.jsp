<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 14.06.2018
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">
    <title>Прохожение теста</title>
</head>
<body>
<form action="tryToCheckTest" method="post">
    <div>
        <div>
            <h2>${testQuestion.questionText}</h2>
            <input type="hidden" name="testQuestionId" value="${testQuestion.id}"/>
        </div>
        <br>
        <c:forEach items="${requestScope.completeTests}" var="answer">
            <div>
                <input name="check" id="checkBox" type="checkbox" value="${answer.answerId}">
                <label for="checkBox">${answer.getAnswerText()}</label>
            </div>
        </c:forEach>
    </div>
    <input type="hidden" name="end" value="${requestScope.end}"/>
    <c:if test="${not requestScope.end}">
        <input type="submit" class="btn btn-primary" value="Ответить">
    </c:if>
    <c:if test="${requestScope.end}">
        <input type="submit" class="btn btn-primary" value="Завершить">
    </c:if>
</form>
</body>
</html>
