import java.util.*;
import java.io.*;
import javax.servlet.*;
public class servlet02 extends GenericServlet
{
	public void service(ServletRequest request,ServletResponse response)
	throws IOException,ServletException
	{
		PrintWriter pw = response.getWriter();
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements())
		{
			String pname = (String)e.nextElement();
			pw.print(pname +" = ");
			String pvalue = request.getParameter(pname);
			pw.println(pvalue);
		}	
	pw.close();
	}
}