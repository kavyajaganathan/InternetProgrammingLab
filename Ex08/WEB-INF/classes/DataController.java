import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DataController extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        String total = "";
        String soap = "";
        String apples = "";
        String handwash = "";

        try {
            response.setContentType("text/plain");

            PrintWriter out = response.getWriter();
            out.println("Received!");

            total = request.getParameter("total");
            soap = request.getParameter("soap");
            apples = request.getParameter("apples");
            handwash = request.getParameter("handwash");

            if (!total.isEmpty()) {
                Cookie totalCookie = new Cookie("total", total);
                totalCookie.setMaxAge(7200);
                response.addCookie(totalCookie);
            }

            if (!soap.isEmpty()) {
                Cookie soapCookie = new Cookie("soap", soap);
                soapCookie.setMaxAge(7200);
                response.addCookie(soapCookie);
            }

            if (!apples.isEmpty()) {
                Cookie applesCookie = new Cookie("apples", apples);
                applesCookie.setMaxAge(7200);
                response.addCookie(applesCookie);
            }

            if (!handwash.isEmpty()) {
                Cookie handwashCookie = new Cookie("handwash", handwash);
                handwashCookie.setMaxAge(7200);
                response.addCookie(handwashCookie);
            }

        } catch (Exception E) { System.out.println(E); }
    }
}
