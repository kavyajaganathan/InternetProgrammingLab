<%-- 
    Document   : view
    Created on : 15 Apr, 2020, 7:50:46 PM
    Author     : nanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <h1>View All Reviews</h1>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	webservices.Ex12WebService_Service service = new webservices.Ex12WebService_Service();
	webservices.Ex12WebService port = service.getEx12WebServicePort();
	java.lang.String result = port.showReview();
        result = result.replaceAll("\\n", "<br>");
	out.println(result);
    } catch (Exception ex) {
	out.println("An error occurred!");
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
