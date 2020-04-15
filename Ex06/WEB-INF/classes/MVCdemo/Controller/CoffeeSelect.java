package MVCdemo.Controller;
import MVCdemo.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CoffeeSelect extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse res)
    {
        String c = request.getParameter("color");
        CoffeeExpert ce = new CoffeeExpert();
        try
        {
            String result = ce.getBrands(c);
            request.setAttribute("styles", result);
            RequestDispatcher view = request.getRequestDispatcher("/result.jsp");
            view.forward(request, res);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

