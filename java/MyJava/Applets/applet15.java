/*<applet code=applet15 width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
public class applet15 extends Applet
{
	public void paint(Graphics g)
	{
		Color c1 = new Color(205,10,255);
		Color c2 = new Color(100,255,100);
		Color c3 = new Color(100,100,255);
		g.setColor(c1);
		g.fillRect(10,10,100,75);
		g.setColor(c2);
		g.fillOval(200,10,100,75);
		g.setColor(c3);
		g.fillRoundRect(100,200,100,80,10,10);
		g.setColor(new Color(222,22,222));
		g.fillArc(300,300,100,100,0,180);
		g.fillArc(200,300,100,100,0,-180);
	}
}