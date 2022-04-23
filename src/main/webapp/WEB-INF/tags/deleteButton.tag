<%@ attribute name="id" type="java.lang.Long" %>

<button hx-delete="/todos/${id}" hx-target="closest li" hx-swap="delete">
    Delete
</button>