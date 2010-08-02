/*<applet code=applet05 height=75 width=100></applet>*/
import java.applet.*;
import java.awt.*;
public class applet05 extends Applet
{
	public void init()
	{
		setBackground(Color.lightGray);
	}
	public void start()
	{
	}
	public void paint(Graphics g)
	{
		g.drawString("This is shown in the Applet Window.",75,100);
		showStatus("This is shown in the Status Window.");
	}
}