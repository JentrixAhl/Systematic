<%@ page import="se.distansakademin.models.Project" %>
<%@ page import="se.distansakademin.models.Project" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% var project = (Project) request.getAttribute("project"); %>
<html>
<head>
  <title>Update project</title>
</head>
<body>

<h1>Update project</h1>


<form action="${pageContext.request.contextPath}/projects" method="post">
  <input type="text" name="title" placeholder="Title" value="<%= project.getTitle() %>"> <br>
  <input type="text" name="description" placeholder="Description" value="<%= project.getDescription() %>"> <br>

  <input type="hidden" name="action" value="update">
  <input type="hidden" name="id" value="<%= project.getId() %>">

  <button type="submit">Update</button>
</form>

<br>

<form action="${pageContext.request.contextPath}/projects" method="post">
  <input type="hidden" name="action" value="delete">
  <input type="hidden" name="id" value="<%= project.getId() %>">

  <input type="submit" value="Delete">
</form>

</body>
</html>
