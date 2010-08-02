/*<applet code=applet10 width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
public class applet10 extends Applet
{
	public void paint(Graphics g)
	{
		g.drawOval(20,20,100,100);
		g.fillOval(40,40,60,60);
		g.drawOval(160,160,100,50);
		g.fillOval(200,100,70,25);
	}
}