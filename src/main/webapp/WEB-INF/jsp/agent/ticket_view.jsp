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

<div class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
    <h1>Просмотр заявки</h1>
    <table class="table table-bordered">
        <tr>
            <td>Расширение времени выполнения</td>
            <td>${escalationSolutionTime}</td>
        </tr>
        <tr>
            <td>Создан</td>
            <td>${createBy}</td>
        </tr>
        <tr>
            <td>Приоритет</td>
            <td>${priority}</td>
        </tr>
        <tr>
            <td>Идентификатор клиента</td>
            <td>${customerID}</td>
        </tr>
        <tr>
            <td>Идентификатор ответственного</td>
            <td>$responsibleID{}</td>
        </tr>
        <tr>
            <td>В данное время не используется</td>
            <td>${realTillTimeNotUsed}</td>
        </tr>
        <tr>
            <td>Расширение времени обновления</td>
            <td>${escalationUpdateTime}</td>
        </tr>
        <tr>
            <td>Расширение времени ответа</td>
            <td>${escalationResponseTime}</td>
        </tr>
        <tr>
            <td>Идентификатор типа</td>
            <td>${typeID}</td>
        </tr>
        <tr>
            <td>В архиве</td>
            <td>${archiveFlag}</td>
        </tr>
        <tr>
            <td>Осталось времени</td>
            <td>${untilTime}</td>
        </tr>
        <tr>
            <td>Идентификатор приоритета</td>
            <td>${priorityID}</td>
        </tr>
        <tr>
            <td>Дата создания</td>
            <td>${getCreated}</td>
        </tr>
        <tr>
            <td>Идентификатор очереди</td>
            <td>${queueID}</td>
        </tr>
        <tr>
            <td>Идентификатор владельца</td>
            <td>${ownerID}</td>
        </tr>
        <tr>
            <td>Увеличение времени</td>
            <td>${escalationTime}</td>
        </tr>
        <tr>
            <td>Владелец</td>
            <td>${owner}</td>
        </tr>
        <tr>
            <td>SLAID</td>
            <td>${slaid}</td>
        </tr>
        <tr>
            <td>Время ожидания разблокировки</td>
            <td>${unlockTimeout}</td>
        </tr>
        <tr>
            <td>Идентификатор блокировки</td>
            <td>${getLockID}</td>
        </tr>
        <tr>
            <td>Идентификатор клиента</td>
            <td>${customerUserID}</td>
        </tr>
        <tr>
            <td>Идентификатор состояния</td>
            <td>${stateID}</td>
        </tr>
        <tr>
            <td>Идентификатор группы</td>
            <td>${groupID}</td>
        </tr>
        <tr>
            <td>Еденица времени</td>
            <td>${timeUnit}</td>
        </tr>
        <tr>
            <td>Идентификатор службы</td>
            <td>${serviceID}</td>
        </tr>
        <tr>
            <td>Заблокированно</td>
            <td>${lock}</td>
        </tr>
        <tr>
            <td>Статус</td>
            <td>${state}</td>
        </tr>
        <tr>
            <td>Тип</td>
            <td>${type}</td>
        </tr>
        <tr>
            <td>Ответственный</td>
            <td>${responsible}</td>
        </tr>
        <tr>
            <td>Изменён</td>
            <td>${changeBy}</td>
        </tr>
        <tr>
            <td>Тип статуса</td>
            <td>${stateType}</td>
        </tr>
        <tr>
            <td>Очередь</td>
            <td>${queue}</td>
        </tr>
        <tr>
            <td>Изменено</td>
            <td>${changed}</td>
        </tr>
        <tr>
            <td>Номер заявки</td>
            <td>${ticketNumber}</td>
        </tr>
        <tr>
            <td>Заголовок</td>
            <td>${title}</td>
        </tr>
        <tr>
            <td>Возраст</td>
            <td>${age}</td>
        </tr>
        <tr>
            <td>Идентификатор заявки</td>
            <td>${ticketID}</td>
        </tr>
    </table>
</div> 

<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>

</html>