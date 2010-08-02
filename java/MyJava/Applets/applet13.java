/*<applet code=applet13 width=200 height=200></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class applet13 extends Applet
{
	int max=500,min=200;
	final int inc=25;
	Dimension d;
	public void init()
	{
		addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent me)
			{
				int w=(d.width+inc)>max?min:(d.width+inc);
				int h=(d.height+inc)>max?min:(d.height+inc);
				setSize(new Dimension(w,h));
			}
		});
	}
	public void paint(Graphics g)
	{
		d = getSize();
		g.drawLine(0,0,d.width-1,d.height-1);
		g.drawLine(0,d.height-1,d.width-1,0);
		g.drawRect(0,0,d.width-1,d.height-1);
	}
}