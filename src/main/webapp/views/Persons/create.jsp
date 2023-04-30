<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create person</title>
</head>
<body>
<h1>Create person</h1>

<form action="${pageContext.request.contextPath}/persons" method="post">
    <input type="text" name="firstName" placeholder="First Name"> <br>
    <textarea name="yearOfBirth" placeholder="Year of Birth"></textarea> <br>
    <input type="submit" value="Create person">
</form>
</body>
</html>

