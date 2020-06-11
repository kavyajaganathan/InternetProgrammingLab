import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginController extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            String name = request.getParameter("name");

            Cookie nameCookie = new Cookie("name", name);
            nameCookie.setMaxAge(7200);
            response.addCookie(nameCookie);

            request.setAttribute("name", name);
            RequestDispatcher view = request.getRequestDispatcher("/home.jsp");
            view.forward(request, response);

        } catch (Exception E) { System.out.println(E); }
    }
}
