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
            <td>${ticket.escalationSolutionTime}</td>
        </tr>
        <tr>
            <td>Создан</td>
            <td>${ticket.createBy}</td>
        </tr>
        <tr>
            <td>Приоритет</td>
            <td>${ticket.priority}</td>
        </tr>
        <tr>
            <td>Идентификатор клиента</td>
            <td>${ticket.customerID}</td>
        </tr>
        <tr>
            <td>Идентификатор ответственного</td>
            <td>${ticket.responsibleID}</td>
        </tr>
        <tr>
            <td>В данное время не используется</td>
            <td>${ticket.realTillTimeNotUsed}</td>
        </tr>
        <tr>
            <td>Расширение времени обновления</td>
            <td>${ticket.escalationUpdateTime}</td>
        </tr>
        <tr>
            <td>Расширение времени ответа</td>
            <td>${ticket.escalationResponseTime}</td>
        </tr>
        <tr>
            <td>Идентификатор типа</td>
            <td>${ticket.typeID}</td>
        </tr>
        <tr>
            <td>В архиве</td>
            <td>${ticket.archiveFlag}</td>
        </tr>
        <tr>
            <td>Осталось времени</td>
            <td>${ticket.untilTime}</td>
        </tr>
        <tr>
            <td>Идентификатор приоритета</td>
            <td>${ticket.priorityID}</td>
        </tr>
        <tr>
            <td>Дата создания</td>
            <td>${ticket.created}</td>
        </tr>
        <tr>
            <td>Идентификатор очереди</td>
            <td>${ticket.queueID}</td>
        </tr>
        <tr>
            <td>Идентификатор владельца</td>
            <td>${ticket.ownerID}</td>
        </tr>
        <tr>
            <td>Увеличение времени</td>
            <td>${ticket.escalationTime}</td>
        </tr>
        <tr>
            <td>Владелец</td>
            <td>${ticket.owner}</td>
        </tr>
        <tr>
            <td>SLAID</td>
            <td>${ticket.slaid}</td>
        </tr>
        <tr>
            <td>Время ожидания разблокировки</td>
            <td>${ticket.unlockTimeout}</td>
        </tr>
        <tr>
            <td>Идентификатор блокировки</td>
            <td>${ticket.lockID}</td>
        </tr>
        <tr>
            <td>Идентификатор клиента</td>
            <td>${ticket.customerUserID}</td>
        </tr>
        <tr>
            <td>Идентификатор состояния</td>
            <td>${ticket.stateID}</td>
        </tr>
        <tr>
            <td>Идентификатор группы</td>
            <td>${ticket.groupID}</td>
        </tr>
        <tr>
            <td>Еденица времени</td>
            <td>${ticket.timeUnit}</td>
        </tr>
        <tr>
            <td>Идентификатор службы</td>
            <td>${ticket.serviceID}</td>
        </tr>
        <tr>
            <td>Заблокированно</td>
            <td>${ticket.lock}</td>
        </tr>
        <tr>
            <td>Статус</td>
            <td>${ticket.state}</td>
        </tr>
        <tr>
            <td>Тип</td>
            <td>${ticket.type}</td>
        </tr>
        <tr>
            <td>Ответственный</td>
            <td>${ticket.responsible}</td>
        </tr>
        <tr>
            <td>Изменён</td>
            <td>${ticket.changeBy}</td>
        </tr>
        <tr>
            <td>Тип статуса</td>
            <td>${ticket.stateType}</td>
        </tr>
        <tr>
            <td>Очередь</td>
            <td>${ticket.queue}</td>
        </tr>
        <tr>
            <td>Изменено</td>
            <td>${ticket.changed}</td>
        </tr>
        <tr>
            <td>Номер заявки</td>
            <td>${ticket.ticketNumber}</td>
        </tr>
        <tr>
            <td>Заголовок</td>
            <td>${ticket.title}</td>
        </tr>
        <tr>
            <td>Возраст</td>
            <td>${ticket.age}</td>
        </tr>
        <tr>
            <td>Идентификатор заявки</td>
            <td>${ticket.ticketID}</td>
        </tr>
    </table>
</div> 

<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>

</html>