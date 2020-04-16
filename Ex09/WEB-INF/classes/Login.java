import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplab", "root", "");
			Statement st = con.createStatement();
			String id = req.getParameter("id");
			String dob = req.getParameter("dob");
			ResultSet rs = st.executeQuery("SELECT * FROM members WHERE id = '" + id + "';");
			if(rs.next()) {
				if(dob.equals(rs.getString("dob"))) {
					RequestDispatcher r = req.getRequestDispatcher("/user.jsp");
					r.forward(req, res);
				}
				else {
					PrintWriter out = res.getWriter();
					res.setContentType("text/html");
					out.println("<h2>Login Failed!</h2>");
					out.println("Check your credentials again and retry!");
				}
			}
			else {
				PrintWriter out = res.getWriter();
				res.setContentType("text/html");
				out.println("<h2>Login Failed!</h2>");
				out.println("No such user. Contact the Library to register.");
			}
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
