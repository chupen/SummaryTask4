<%--
  Created by IntelliJ IDEA.
  User: chupa
  Date: 13.06.2018
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Авторизация</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"><br></nav>
<div align="center">
    <br>
    <form action="tryToLogin" method="post">
        <div class="form-group">
            <div class="col-2">
                <input class="form-control" id="login" type="text" name="login" minlength="2" maxlength="24"
                       placeholder="Логин"/>
            </div>
        </div>
        <div>
            <div class="col-2">
                <input class="form-control" id="password" type="password" name="password" minlength="3" maxlength="24"
                       placeholder="Пароль"/>
            </div>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Войти</button>
    </form>
    <br>
    <form action="tryToRegister" method="post">
        <div class="form-group">
            <div class="col-2">
                <input class="form-control" id="login1" type="text" name="login" minlength="3" maxlength="24"
                       placeholder="Логин"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-2">
                <input class="form-control" id="password1" type="password" name="password" minlength="3" maxlength="24"
                       placeholder="Пароль"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-2">
                <input class="form-control" id="email" type="text" name="email" minlength="6" maxlength="50"
                       placeholder="Почта"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-2">
                <input class="form-control" id="name" type="text" name="name" minlength="2" maxlength="24"
                       placeholder="Имя"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-2">
                <input class="form-control" id="surname" type="text" name="surname" minlength="2" maxlength="24"
                       placeholder="Фамилия"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
    </form>
</div>
</body>
</html>
