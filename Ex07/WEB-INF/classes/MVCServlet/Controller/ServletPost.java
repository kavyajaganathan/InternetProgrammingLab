package MVCServlet.Controller;

import MVCServlet.Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class ServletPost extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Login model = new Login();
        model.connectToDatabase();
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        int res = model.authenticate(name, pass);
        if(res == 1)
        {
            String id = model.getID(name, pass);
            int[] marks = model.getMarks(id); 
            out.print("<b>Student ID:</b> " + id + "<br/>");
            out.print("<b>Name:</b> " + name + "<br/><br/><br/>");
            out.print("<table border = 1pt align = center><tr><th>Subject</th><th>mark</th></tr>");
            out.print("<tr> <td>Mathematics</td> <td>" + marks[0] + "</td> </tr>");
            out.print("<tr> <td>English</td> <td>" + marks[1] + "</td> </tr>");
            out.print("<tr> <td>Physics</td> <td>" + marks[2] + "</td> </tr>");
            out.print("<tr> <td>Chemistry</td> <td>" + marks[3] + "</td> </tr>");
            out.print("<tr> <td>Computer Science</td> <td>" + marks[4] + "</td> </tr></table><br/><br/><br/>");
            int sum = marks[0] + marks[1] + marks[2] + marks[3] + marks[4];
            double avg = sum / 5.0;
            out.print("<b>Total: </b> " + sum + "<br/>");
            out.print("<b>Average: </b> " + avg + "<br/>");
            out.print("<b>Grade: </b> ");
            if (avg > 90) out.print("O");
            else if (avg > 80)  out.print("A");
            else if (avg > 70)  out.print("B");
            else if (avg > 60)  out.print("C");
            else if (avg > 50)  out.print("D");
            else out.print("E");
        }
    }
}
