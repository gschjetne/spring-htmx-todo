<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="item" type="se.schjetne.springhtmxtodo.Todo" %>
<li hx-get="/todos/${item.id}" hx-trigger="dblclick" hx-swap="outerHTML">
    <c:choose>
        <c:when test="${item.done}">
            <input type="checkbox"
                   name="done"
                   hx-put="/todos/${item.id}"
                   hx-target="closest li"
                   hx-swap="outerHTML"
                   hx-include="closest li" checked/>
        </c:when>
        <c:otherwise>
            <input type="checkbox"
                   name="done"
                   hx-put="/todos/${item.id}"
                   hx-target="closest li"
                   hx-swap="outerHTML"
                   hx-include="closest li"/>
        </c:otherwise>
    </c:choose>
    <span class="${item.done ? "item-done" : ""}">${item.task}</span>
    <input type="hidden" name="task" value="${item.task}">
    <t:deleteButton id="${item.id}"/>
</li>