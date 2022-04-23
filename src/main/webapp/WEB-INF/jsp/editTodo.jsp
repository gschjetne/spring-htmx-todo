<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<li>
    <c:choose>
        <c:when test="${todo.done}">
            <input type="checkbox" name="done" checked/>
        </c:when>
        <c:otherwise>
            <input type="checkbox"
                   name="done"/>
        </c:otherwise>
    </c:choose>
    <input name="task" value="${todo.task}"/>
    <button hx-put="/todos/${todo.id}"
            hx-include="closest li"
            hx-target="closest li"
            hx-swap="outerHTML"
    >
        Save
    </button>
</li>