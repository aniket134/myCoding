import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author nik
 */
public class loginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException,ServletException
    {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String color = request.getParameter("color");
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<b>name: "+name);
        pw.println("password: "+pass);
        pw.println("color: "+color);
        pw.close();
    }
}
