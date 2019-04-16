<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    System.out.println(username);
    System.out.println(password);


    if (username != null && password != null) {
        if (username.equals("admin") && password.equals("pass")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="/login.jsp">
        <input name="username" type="text" placeholder="username">
        <input name="password" id="password" type="password" placeholder="password">
        <button type="submit">Submit</button>
    </form>
</body>
</html>
