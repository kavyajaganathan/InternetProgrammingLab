import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ResultServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String uname = request.getParameter("uname");
        String[] marks = request.getParameterValues("mark");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Results for " + uname + "</h1>");
        int total = 0; String grade;
        for(int i = 0; i < marks.length; i++) {
            total += Integer.parseInt(marks[i]);
        }
        if(total == 500) {
            grade = new String("O+");
        }
        else if(total > 450) {
            grade = new String("O");
        }
        else if(total > 400) {
            grade = new String("A+");
        }
        else if(total > 350) {
            grade = new String("A");
        }
        else if(total > 300) {
            grade = new String("B+");
        }
        else if(total > 250) {
            grade = new String("B");
        }
        else {
            grade = new String("U");
        }
        out.println("Total: " + total + " <br>");
        out.println("Average: " + total / marks.length + " <br>");
        out.println("Grade: " + grade + " <br>");
        out.println("</body>");
        out.println("</html>");
    }
}
