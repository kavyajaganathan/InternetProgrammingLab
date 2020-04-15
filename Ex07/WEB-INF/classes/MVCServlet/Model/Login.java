package MVCServlet.Model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Login
{
    Connection con;
    public int authenticate (String user, String pwd)
    {
        try {
            String sql = "select * from users where name = '" + user + "' and pwd = '" + pwd + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                return 1;
            }
            else {
                return 0;
            }
        }
        catch (Exception e) {
            return 0;
        }
    }
    public String getID (String user, String pwd)
    {
        try {
            String sql = "select * from users where name = '" + user + "' and pwd = '" + pwd + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                return rs.getString("id");
            }
            else {
                return "0";
            }
            
        }
        catch (Exception e) {
          return "0";
        }
    }
    public int[] getMarks(String id)
    {
        int[] marks = new int[5];
        try {
            String sql = "select * from result where id = '" + id + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                marks[0] = Integer.parseInt(rs.getString("maths"));
                marks[1] = Integer.parseInt(rs.getString("english"));
                marks[2] = Integer.parseInt(rs.getString("physics"));
                marks[3] = Integer.parseInt(rs.getString("chemistry"));
                marks[4] = Integer.parseInt(rs.getString("computerscience"));
                return marks;
            }
            else {
                return marks;
            }
        }
        catch (Exception e) {
            return marks;
        }
    }
    public void connectToDatabase()
    {
        try {
            String user = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplab", user, password);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
