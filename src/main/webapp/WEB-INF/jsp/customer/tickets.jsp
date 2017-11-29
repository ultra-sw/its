<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import = "java.util.List" %>
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

<%
    String str = request.getAttribute("Tickets").toString();
        str = str.replaceAll("[^0-9]+", " ");
        String[] tickets = str.split(" ");
         %>
 </head>
 <body>
 <jsp:directive.include file="/WEB-INF/jspf/head.jspf" />
 <center>
 <table>
 <%if(tickets.length>1){
out.println("<tr><th>ID</th><th>Тема заявки</th><th>Дата подачи</th><th>Статус заявки</th></tr>");
    for(int i=1;i<tickets.length;i++)
  out.println(" <tr><td> " + tickets[i] + "</td><td>Ячейка 4</td><td>Ячейка 4</td><td>Ячейка 4</td></tr>");}%>
</table>

</center>





<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>

</html>
