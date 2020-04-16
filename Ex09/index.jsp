<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.*,javax.servlet.http.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
<head>
<title>Library</title>
</head>
<body>
	<center>
		<h1>Library Catalog</h1>
		<h2>Member Login</h2>
		<form method="POST" action="login">
			Library Member ID: <input type="text" name="id">
			DOB (YYYY-MM-DD): <input type="text" name="dob">
			<input type="submit" value="Login">
		</form>
		<h2>Currently Available Books</h2>
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/iplab" user="root" password=""/>
		<sql:query dataSource="${db}" var="result">
			SELECT * FROM books WHERE borrower = 'None';
		</sql:query>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Author</th>
				<th>Pub. Year</th>
				<th>Publisher</th>
				<th>Language</th>
			</tr>
			<c:forEach var="row" items="${result.rows}">
				<tr>
					<td><c:out value="${row.id}"/></td>
					<td><c:out value="${row.name}"/></td>
					<td><c:out value="${row.author}"/></td>
					<td><c:out value="${row.year}"/></td>
					<td><c:out value="${row.publisher}"/></td>
					<td><c:out value="${row.language}"/></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
