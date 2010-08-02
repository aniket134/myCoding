/*<applet code=applet11 width=400 height=500></applet>*/
import java.awt.*;
import java.applet.*;
public class applet11 extends Applet
{
	public void paint(Graphics g)
	{
		g.drawArc(100,100,50,40,0,90);
		g.drawRect(100,100,50,40);
		g.drawRect(200,200,50,40);
		g.fillArc(200,200,50,40,0,270);
	}
}