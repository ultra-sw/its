<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automatically -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />

	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />

    <%--<c:url value="/css/main.css" var="jstlCss" />--%>
    <%--<link href="${jstlCss}" rel="stylesheet" />--%>

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">ИНТЕГРАЛ</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Войти</a></li>
                <li><a href="#about">Справка</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>Система учёта заявок</h1>
        <h2>Message: ${message}</h2>
    </div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>

</html>
