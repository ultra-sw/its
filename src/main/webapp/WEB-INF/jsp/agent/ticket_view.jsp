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
<jsp:directive.include file="/WEB-INF/jspf/agent_head.jspf"/>

<div class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-5">
    <h1>Просмотр заявки</h1>
    <table class="table table-bordered">
        <tr>
            <td>escalationSolutionTime</td>
            <td>${escalationSolutionTime}</td>
        </tr>
        <tr>
            <td>createBy</td>
            <td>${createBy}</td>
        </tr>
        <tr>
            <td>priority</td>
            <td>${priority}</td>
        </tr>
        <tr>
            <td>customerID</td>
            <td>${customerID}</td>
        </tr>
        <tr>
            <td>responsibleID</td>
            <td>$responsibleID{}</td>
        </tr>
        <tr>
            <td>realTillTimeNotUsed</td>
            <td>${realTillTimeNotUsed}</td>
        </tr>
        <tr>
            <td>escalationUpdateTime</td>
            <td>${escalationUpdateTime}</td>
        </tr>
        <tr>
            <td>escalationResponseTime</td>
            <td>${escalationResponseTime}</td>
        </tr>
        <tr>
            <td>typeID</td>
            <td>${typeID}</td>
        </tr>
        <tr>
            <td>archiveFlag</td>
            <td>${archiveFlag}</td>
        </tr>
        <tr>
            <td>untilTime</td>
            <td>${untilTime}</td>
        </tr>
        <tr>
            <td>priorityID</td>
            <td>${priorityID}</td>
        </tr>
        <tr>
            <td>getCreated</td>
            <td>${getCreated}</td>
        </tr>
        <tr>
            <td>queueID</td>
            <td>${queueID}</td>
        </tr>
        <tr>
            <td>ownerID</td>
            <td>${ownerID}</td>
        </tr>
        <tr>
            <td>escalationTime</td>
            <td>${escalationTime}</td>
        </tr>
        <tr>
            <td>owner</td>
            <td>${owner}</td>
        </tr>
        <tr>
            <td>slaid</td>
            <td>${slaid}</td>
        </tr>
        <tr>
            <td>unlockTimeout</td>
            <td>${unlockTimeout}</td>
        </tr>
        <tr>
            <td>getLockID</td>
            <td>${getLockID}</td>
        </tr>
        <tr>
            <td>customerUserID</td>
            <td>${customerUserID}</td>
        </tr>
        <tr>
            <td>stateID</td>
            <td>${stateID}</td>
        </tr>
        <tr>
            <td>groupID</td>
            <td>${groupID}</td>
        </tr>
        <tr>
            <td>timeUnit</td>
            <td>${timeUnit}</td>
        </tr>
        <tr>
            <td>serviceID</td>
            <td>${serviceID}</td>
        </tr>
        <tr>
            <td>lock</td>
            <td>${lock}</td>
        </tr>
        <tr>
            <td>state</td>
            <td>${state}</td>
        </tr>
        <tr>
            <td>type</td>
            <td>${type}</td>
        </tr>
        <tr>
            <td>responsible</td>
            <td>${responsible}</td>
        </tr>
        <tr>
            <td>changeBy</td>
            <td>${changeBy}</td>
        </tr>
        <tr>
            <td>stateType</td>
            <td>${stateType}</td>
        </tr>
        <tr>
            <td>queue</td>
            <td>${queue}</td>
        </tr>
        <tr>
            <td>changed</td>
            <td>${changed}</td>
        </tr>
        <tr>
            <td>ticketNumber</td>
            <td>${ticketNumber}</td>
        </tr>
        <tr>
            <td>title</td>
            <td>${title}</td>
        </tr>
        <tr>
            <td>age</td>
            <td>${age}</td>
        </tr>
        <tr>
            <td>ticketID</td>
            <td>${ticketID}</td>
        </tr>
    </table>
</div> 

<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>

</html>