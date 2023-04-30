<%@ page import="se.distansakademin.models.Person" %>
<%@ page import="se.distansakademin.models.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% var person = (Person) request.getAttribute("person"); %>
<html>
<head>
    <title>Update person</title>
</head>
<body>

<h1>Update person</h1>


<form action="${pageContext.request.contextPath}/persons" method="post">
    <input type="text" name="firstName" placeholder="First Name" value="<%= person.getFirstName() %>"> <br>
    <input type="text" name="yearOfBirth" placeholder="Year Of Birth" value="<%= person.getYearOfBirth() %>"> <br>

    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= person.getId() %>">

    <button type="submit">Update</button>
</form>

<br>

<form action="${pageContext.request.contextPath}/persons" method="post">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" value="<%= person.getId() %>">

    <input type="submit" value="Delete">
</form>

</body>
</html>
