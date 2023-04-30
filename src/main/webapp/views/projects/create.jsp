<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create project</title>
</head>
<body>
<h1>Create project</h1>

<form action="${pageContext.request.contextPath}/projects" method="post">
  <input type="text" name="title" placeholder="Title"> <br>
  <input type="text" name="description" placeholder="Description"> <br>
  <button type="submit">Create</button>
</form>

</body>
</html>
