import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DeleteCookie extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Delete Cookies</title></head>");

        if (cookies != null) {
            out.println("<h2>Cookies Name and Value</h2>");

            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                out.print("Deleted cookie: " + cookie.getName() + "<br/>");
                out.print("Value: " + cookie.getValue() + " <br/>");
            }
        } else {
            out.println("<h2>No cookies found!</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
