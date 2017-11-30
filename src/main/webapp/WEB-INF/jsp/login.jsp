<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <!-- Access the bootstrap Css like this, Spring boot will handle the resource mapping automatically -->
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>

    <spring:url value="/css/main.css" var="springCss"/>
    <link href="${springCss}" rel="stylesheet"/>

    <%--<c:url value="/css/main.css" var="jstlCss"/>--%>
    <%--<link href="${jstlCss}" rel="stylesheet"/>--%>

</head>
<body>

<jsp:directive.include file="/WEB-INF/jspf/login_head.jspf"/>
<div class="container">
    <div class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-5">
        <h1>Войти в личный кабинет</h1>
        <form action="/login" method="post">
            <div class="form-group">
                <input class="form-control" type="text" name="username" value="" placeholder="Логин или Email"/>
            </div>
            <div class="form-group">
                <input class="form-control" type="password" name="password" value="" placeholder="Пароль"/>
            </div>
            <label class="text-danger">${wrong_text}</label>           
            <div class="form-group">
                <div class="row">   
                    <div class="col-xs-6">
                        <input type="checkbox" name="remember_me" id="remember_me"/> Запомнить меня
                    </div>
                    <div class="col-xs-6 text-right">                    
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input class="btn btn-default" type="submit" name="enter" value="Войти"/>
                    </div>
                </div>
            </div>
        </form>
        <a href="index.html">Забыли пароль?</a> Восстановите его!
    </div>
</div>

<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>

</html>