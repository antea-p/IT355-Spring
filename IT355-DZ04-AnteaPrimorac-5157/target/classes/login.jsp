<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="loginAction.jsp" method="post">
    Email: <input type="email" name="email" required><br>
    Password: <input type="password" name="password" required><br>
    <input type="submit" value="Login">
</form>
<%
    String error = request.getParameter("error");
    if ("true".equals(error)) {
%>
<script type="text/javascript">
    console.log("Executing script");
    alert('Invalid email or password.');
</script>
<%
    }
%>
</body>
</html>
