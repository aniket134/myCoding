import java.awt.event.*;
import java.applet.*;
import java.awt.*;
/*<applet code=bounce width=500 height=500></applet>*/
public class bounce extends Applet implements Runnable,ActionListener
{
	Button b;
	private Thread ticker;
	private boolean running=true;
	int x=100,y=100;
	int dx=2,dy=2;
	public void init()
	{
		b = new Button("Stop");
		setBackground(Color.cyan);
		ticker = new Thread(this);
		add(b);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		stop();
	}
	public void run()
	{
		while(running)
		{
			repaint();
			try
			{
				ticker.sleep(100);
				if(x<=1)
				{
					if(y<=1)
					{
						x=400;y=400;
					}
					else {x=400;}
				}else{}
			x=x-2;y=y-2;
			}
			catch(InterruptedException e)
			{
			}
		}
	}
	public synchronized void start()
	{
		ticker.start();
	}
	public synchronized void stop()
	{
		start();
	}
	public void paint(Graphics g)
	{
		if(!ticker.isAlive())
		System.out.println("Thread is not Alive.");
		g.fillOval(x,y,100,100);
	}
}