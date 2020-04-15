<%-- 
    Document   : result
    Created on : 15 Apr, 2020, 7:45:24 PM
    Author     : nanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        <h1>Review Submission</h1>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	webservices.Ex12WebService_Service service = new webservices.Ex12WebService_Service();
	webservices.Ex12WebService port = service.getEx12WebServicePort();
	java.lang.String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	int rating = Integer.parseInt(request.getParameter("rating"));
	java.lang.String review = request.getParameter("review");
	java.lang.String result = port.recordReview(name, age, rating, review);
	out.println("Result = " + result);
    } catch (Exception ex) {
	out.println("An error occurred!");
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
