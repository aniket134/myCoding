/*<applet code=applet18 width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
public class applet18 extends Applet
{
	int curX=0,curY=0;
	public void init()
	{
		Font f = new Font("SansSerif",Font.PLAIN,12);
		setFont(f);
	}
	public void paint(Graphics g)
	{
		nextLine("This is line no. 1",g);
		nextLine("This is line no. 2",g);
		sameLine("This is on the same line",g);
		sameLine("This too!",g);
	}
	void nextLine(String s, Graphics g)
	{
		FontMetrics fm = g.getFontMetrics();
		curY+=fm.getHeight();
		curX=0;
		g.drawString(s,curX,curY);
		curX+=fm.stringWidth(s);
	}
	void sameLine(String s,Graphics g)
	{
		FontMetrics fm = g.getFontMetrics();
		g.drawString(s,curX,curY);
		curX+=fm.stringWidth(s);
	}
}