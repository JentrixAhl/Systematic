<%@ page import="se.distansakademin.models.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="se.distansakademin.models.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Persons index</title>
</head>
<body>
<h1>Persons index</h1>

<% for (Person person : (List<Person>) request.getAttribute("persons")) { %>
<p>
  <b> <%= person.getFirstName() %> </b> <br>
  <i> <%= person.getYearOfBirth() %> </i>
  <a href="?action=update&id=<%= person.getId() %>">Update</a>
</p>
<% } %>

<p>
  <a href="?action=create">Create person</a>
</p>

</body>
</html>

