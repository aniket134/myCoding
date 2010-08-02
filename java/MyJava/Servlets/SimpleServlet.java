import java.io.*;
import javax.servlet.*;
public class SimpleServlet extends GenericServlet
{
	public void service(ServletRequest request,ServletResponse response)
	throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<b>Hello!");
		pw.close();
	}
}