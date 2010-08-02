/*<applet code=applet07 height=75 width=100></applet>*/
import java.applet.*;
import java.awt.*;
import java.net.*;
public class applet07 extends Applet
{
	public void paint(Graphics g)
	{
		String msg=null;
		URL url=null;
		url=getCodeBase();
		msg = "Code Base (ie, where applet class file is present): "+url.toString();
		g.drawString(msg,75,50);
		url=getDocumentBase();
		msg="Document Base (ie, where the HTML file is contained): "+url.toString();
		g.drawString(msg,75,60);
	}
}