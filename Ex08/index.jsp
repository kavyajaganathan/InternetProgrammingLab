<%@ page import="java.util.*" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>
    <form id="loginform" action="login" method="POST" accept-charset=utf-8>
        Enter your username: <input id="usernameText" type="text" name="name"><br>
        <input type="submit" value="Login">
    </form>

    <%
        Cookie cookie = null;
        Cookie[] cookies = null;
        String nameKey = "name";
        String nameValue = "NULL";
        cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if(nameKey.equals(cookie.getName())) {
                    nameValue = cookie.getValue();
                }
            }
        } else {
            out.println("<h2>No Cookies!</h2>");
        }
    %>

    <script>
        var nameString = "<% out.print(nameValue); %>";
        if (nameString !== "NULL") {
            usernameText.value = nameString;
            loginform.submit();
        }
    </script>
</body>

</html>
