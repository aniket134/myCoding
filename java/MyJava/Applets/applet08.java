/*<applet code=applet08 height=300 width=400></applet>*/
import java.awt.*;
import  java.applet.*;
public class applet08 extends Applet
{
	public void paint(Graphics g)
	{
		g.drawLine(0,0,30,30);
		g.drawLine(0,20,60,60);
		g.drawLine(0,50,100,100);
	}
}