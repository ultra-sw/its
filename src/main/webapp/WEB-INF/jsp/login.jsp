<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automatically -->
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>

    <spring:url value="/css/main.css" var="springCss"/>
    <link href="${springCss}" rel="stylesheet"/>

    <%--<c:url value="/css/main.css" var="jstlCss" />--%>
    <%--<link href="${jstlCss}" rel="stylesheet" />--%>

</head>
<body>

<jsp:directive.include file="/WEB-INF/jspf/head.jspf" />
<section class="container">
    <div class="login">
        <h1>Войти в личный кабинет</h1>
        <form action="/login" method="post">
            <p><input type="text" name="username" value="" placeholder="Логин или Email"></p>
            <p><input type="password" name="password" value="" placeholder="Пароль"></p>
            <label>
               <font color=red>${wrong_text}</font>
            </label>           
            <p class="remember_me">
                <label>
                    <input type="checkbox" name="remember_me" id="remember_me">
                    Запомнить меня
                </label>
            </p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <p class="submit"><input type="submit" name="enter" value="Войти"></p>
        </form>
    </div>

    <div class="login-help">
        <a href="index.html">Забыли пароль?</a> Восстановите его!
    </div>
</section>



<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>

</html>
