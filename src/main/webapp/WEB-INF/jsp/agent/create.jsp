<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automatically -->
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />

	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />

    <%--<c:url value="/css/main.css" var="jstlCss" />--%>
    <%--<link href="${jstlCss}" rel="stylesheet" />--%>

</head>
<body>
<center>

<jsp:directive.include file="/WEB-INF/jspf/head.jspf" />

<div class="container">

    <div class="starter-template">
        <h1>Система учёта заявок</h1>



<br>
<br>


<br>
<form action="/create" method="post">
                <p><input type="text" name="title" value="" placeholder="Заголовок"></p>
                <p><input type="text" name="email" value="" placeholder="e-mail адрес клиента"></p>


                <p><select size="5" name="queue">
                <option disabled>Выберите очередь</option>
                <option value="Raw">Raw</option>
                 <option value="Junk">Junk</option>
                  <option value="Misc">Misc</option>
                   <option value="Postmaster">Postmaster</option>
                </select>


                <select size="5" name="priority">
                <option disabled>Выберите приоритет</option>
                <option value="1 very low">Ничтожный</option>
                <option value="2 low">Низкий</option>
                <option value="3 normal">Обычный</option>
                <option value="4 high">Высокий</option>
                <option value="5 very high">Неотложный</option>
                </select> </p>
                Состояние заявки:
                                   Закрыта <input type="radio" name="state" value="close">
                                    <input type="radio" name="state" value="open" checked> Открыта </p>

                <p><input type="text" name="subject" value="" placeholder="Тема"></p>
                <p><input type="text" name="body" value="" placeholder="Текст заявки"></p>

                <label>
                   <font color=red>${wrong_text}</font>
                </label>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <p class="submit"><input type="submit" name="enterAgent" value="Создать новую заявку"></p>
            </form>
</div>



<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>

</html>
