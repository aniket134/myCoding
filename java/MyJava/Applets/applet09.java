/*<applet code=applet09 width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
public class applet09 extends Applet
{
	public void paint(Graphics g)
	{
		g.drawRect(10,10,100,60);
		g.drawLine(10,10,110,70);
		g.drawLine(10,70,110,10);
		g.fillRect(40,25,30,20);
		g.drawRoundRect(150,150,450,450,10,10);
		g.fillRoundRect(200,200,200,200,30,30);
	}
}