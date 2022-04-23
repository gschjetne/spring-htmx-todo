<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="item" type="se.schjetne.springhtmxtodo.Todo" %>
<li>
    <c:choose>
        <c:when test="${item.done}">
            <input type="checkbox" checked/>
        </c:when>
        <c:otherwise>
            <input type="checkbox"/>
        </c:otherwise>
    </c:choose>
    <span class="${item.done ? "item-done" : ""}">${item.task}</span>
</li>