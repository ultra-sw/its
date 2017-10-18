<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<html>
<head>

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automatically -->
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />

	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />

    <%--<c:url value="/css/main.css" var="jstlCss" />--%>
    <%--<link href="${jstlCss}" rel="stylesheet" />--%>
  <style>
   table {
    width: 70%; /* Ширина таблицы */
    background: white; /* Цвет фона таблицы */
    color: black; /* Цвет текста */
    border-spacing: 1px; /* Расстояние между ячейками */
   }
   td, th {
    background: silver; /* Цвет фона ячеек */
    padding: 5px; /* Поля вокруг текста */
   }
  </style>
</head>
<body>

<jsp:directive.include file="/WEB-INF/jspf/head.jspf" />
<jsp:directive.include file="/WEB-INF/jspf/list_inf.jspf" />
<c:set var="User" value="${ param.username }" />

<h2>Добро пожаловать, ${customerInfo}</h2>


<p><center><table border="1">
<tr>
<th>ID</th>
<th>Отправитель</th>
<th>Тема</th>
<th>Дата</th>
</tr>
<%int i =0;%>
<c:choose>
            <c:when test="${User != null}">
                <h2><%String name = request.getParameter("username");%>
					<%String top = request.getParameter("password");%>
				<%clients.add(clients.size(), name);%>
            </c:when>
            <c:otherwise>
                <h2>Ну такое((</h2>
            </c:otherwise>
        </c:choose>

	
<c:forEach var="tickets" begin="<%=i%>" end="<%=clients.size()-1%>">

<tr><td><%=i%></td><td><%=clients.get(i)%></td><td><%=clients.get(i)%></td><td>Дата</td></tr>
<%i+=1;%>
</c:forEach>
</table>

        

                <form action="/customer/welcome" method="get">
            <p><input type="text" name="username" value="" placeholder="Логин или Email"></p>
            <p><input type="text" name="password" value="" placeholder="Пароль"></p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <p class="submit"><input type="submit" name="enter" value="Войти"></p>
        </form>
		
		
</center></p>
</body>

</html>
