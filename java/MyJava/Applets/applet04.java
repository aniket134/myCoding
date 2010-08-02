import java.applet.*;
import java.awt.*;
/*<applet code=applet04 height=100 width=100></applet>*/
public class applet04 extends Applet implements Runnable
{
	Thread t=null;
	String msg="This is a Simple Moving Banner";
	boolean flagStop;
	public void init()
	{
		setBackground(Color.darkGray);
		setForeground(Color.cyan);
	}
	public void start()
	{
		t = new Thread(this);
		flagStop = false;
		t.start();
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,50,75);
	}
	public void stop()
	{
		flagStop=true;
		t=null;
	}
	public void run()
	{
		char ch;
		while(true)
		{
			try
			{
				repaint();
				Thread.sleep(250);
				ch = msg.charAt(0);
				msg = msg.substring(1,msg.length());
				msg +=ch;
				if(flagStop)
					break;
			}
			catch(InterruptedException e)
			{
			}
		}
	}
}