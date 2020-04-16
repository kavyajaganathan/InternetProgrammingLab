<%@ page import = "java.io.*,java.util.*,java.sql.*" %>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<html>
<head>
<title>Library</title>
</head>
<body>
	<%
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplab", "root", "");
			Statement st = con.createStatement();
			ResultSet details = st.executeQuery("SELECT * FROM members WHERE id = '" + request.getParameter("id") + "';");
			details.next();
			out.println("<h2>Member Details</h2>");
			out.println("Name: " + details.getString("name") + "<br>ID: " + details.getString("id") + "<br>Joined: " + details.getString("joined"));
			ResultSet rs = st.executeQuery("SELECT * FROM books WHERE borrower = '" + request.getParameter("id") + "';");
			out.println("<h2>Borrowed Books</h2>");
			int i = 0;
			while(rs.next()) {
				i++;
				out.println(String.valueOf(i) + ". ID: " + rs.getString("id") + "; Name: " + rs.getString("name") + "<br>");
			}
			if(i == 0) {
				out.println("You haven't borrowed any books!");
			}
		}
		catch (Exception ex) {
			System.out.println("Error!");
		}
	%>
</body>
</html>
