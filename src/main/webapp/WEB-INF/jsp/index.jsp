<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Spring HTMX Todo</title>
        <script src="https://unpkg.com/htmx.org@1.7.0"
                integrity="sha384-EzBXYPt0/T6gxNp0nuPtLkmRpmDBbjg6WmCUZRLXBBwYYmwAUxzlSGej0ARHX0Bo"
                crossorigin="anonymous"
                defer>
        </script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css"/>
    </head>
    <body>
        <h1>Spring HTMX Todo</h1>
        <ul>
            <c:forEach var="todo" items="${todos}">
                <t:todo item="${todo}"/>
            </c:forEach>
            <li id="newForm">
                <input type="checkbox" name="done"/>
                <input name="task"/>
                <button hx-post="/todos"
                        hx-include="closest li"
                        hx-target="#newForm"
                        hx-swap="beforebegin"
                        hx-preserve="#newForm"
                >
                    Save
                </button>
            </li>
        </ul>
    </body>
</html>