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
        <c:choose>
            <c:when test="${customerInfo == null}">
                <h2>Message: ${message} АГЕНТ</h2>
            </c:when>
            <c:otherwise>
                <h2>Добро пожаловать, Агент ${customerInfo}</h2>
            </c:otherwise>
        </c:choose>
        <p><% out.println( "Your IP address is " + request.getRemoteAddr()); %></p>
	    <p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>
	    <%
        HttpSession ses = request.getSession(false);
        String sid = (String) ses.getAttribute("session");
        out.println(sid);
        %>
    </div>
</div>

<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>
</html>