<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<jsp:directive.include file="/WEB-INF/jspf/head.jspf" />
<div class="container">
    <div class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-5">
        <h1>Система учёта заявок</h1>
        <form action="/create" method="post">
            <div class="form-group">
                <input class="form-control" type="text" name="title" value="" placeholder="Заголовок"/>
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="email" value="" placeholder="e-mail адрес клиента"/>
            </div>
            <div class="form-group">
                <select class="form-control" size="5" name="queue">
                    <option disabled>Выберите очередь</option>
                    <option value="Raw">Raw</option>
                    <option value="Junk">Junk</option>
                    <option value="Misc">Misc</option>
                    <option value="Postmaster">Postmaster</option>
                </select>
            </div>
            <div class="form-group">
                <select class="form-control" size="5" name="priority">
                    <option disabled>Выберите приоритет</option>
                    <option value="1 very low">Ничтожный</option>
                    <option value="2 low">Низкий</option>
                    <option value="3 normal">Обычный</option>
                    <option value="4 high">Высокий</option>
                    <option value="5 very high">Неотложный</option>
                </select> 
            </div>
            <div class="form-group">
                Состояние заявки:
                <div class="radio">
                    <label>
                        <input type="radio" name="state" value="open" checked/> Открыта
                    </label>
                </div>
                <div class="radio">
                    <label>                
                        <input type="radio" name="state" value="close"/> Закрыта
                    </label>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="subject" value="" placeholder="Тема"/>
                </div>
                <div class="form-group">
                    <textarea class="form-control" type="text" name="body" value="" placeholder="Текст заявки"></textarea>
                </div>
                <label>${wrong_text}</label>           
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input class="btn btn-default" type="submit" name="enterCustomer" value="Создать новую заявку"/>
            </form>
        </div>
    </div>
 </div>

<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>
</html>