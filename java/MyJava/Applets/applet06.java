/*<applet code=applet06 height=50 width=75>
<param name=fontsize value=15>
<param name=fontcolor value=blue>
<param name=fontvalue value="This is a Param parameter to the Applet.">
</applet>*/
import java.applet.*;
import java.awt.*;
public class applet06 extends Applet
{
	String value=null;
	int size=0;
	String colour="blue";
	public void start()
	{
		colour=getParameter("fontcolor");
		value=getParameter("fontvalue");
		try
		{
			size=Integer.parseInt(getParameter("fontsize"));
		}
		catch(NumberFormatException e)	
		{
			size=-1;
		}
	}
	public void init()
	{
		setBackground(Color.cyan);
	}
	public void paint(Graphics g)
	{
		g.drawString("Font Size: "+size, 10,20);
		g.drawString("Text: "+value, 10,40);
		g.drawString("Font Color: "+colour, 10,60);
	}
}