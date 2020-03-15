import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DetailsServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String uname = request.getParameter("uname");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Enter Details for " + uname + "</h1>");
        out.println("<form method=\"POST\" action=\"result\">");
        for(int i = 1; i < 6; i++) {
            out.println("Subject " + i + " Mark: " + "<input type=\"number\" name=\"mark\"> <br>");
        }
        out.println("<input type=\"hidden\" name=\"uname\" value=\"" + uname + "\">");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
