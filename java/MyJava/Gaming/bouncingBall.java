/*<applet code=bouncingBall width=500 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class bouncingBall extends Applet implements Runnable , ActionListener
{
	int x=200,y=100;
	int dx=2,dy=2;
	boolean rolling = true;
	Thread roll;
	Button b;

	public void init()
	{
		b = new Button("Stop");
		roll = new Thread(this,"Roll");
		roll.setPriority(Thread.MAX_PRIORITY);
		add(b);
		b.addActionListener(this);

	}
	public synchronized void start()
	{
		try
		{
		rolling=true;
		if(roll!=null) roll.start();

		System.out.println(roll);
		if ( !roll.isAlive())
		System.out.println("Thread not alive");
		else{}
		if(roll==null)
		System.out.println("Thread null");

		}
		catch(Exception e)	
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public void run()
	{	
		try
		{
		while(rolling)
		{
			repaint();
		
			if(x<1) x=x+2;
			else if(y<1) y=y+2;
			else if(x>=500) x=x-2;
			else if(y>=500) y=y-2;
			else
			{
				x=x-2;
				y=y-2;
			}
			roll.sleep(100); 
		}
		}
			catch (Exception ie){ System.out.println(ie.getMessage());}
	}
	public void paint(Graphics g)	
	{
		g.fillOval(x+dx,y+dy,50,50);
	}

	public synchronized void stop()
	{
		rolling=false;
	}
	public void actionPerformed(ActionEvent ae)
	{
		rolling=false;
	}
}
