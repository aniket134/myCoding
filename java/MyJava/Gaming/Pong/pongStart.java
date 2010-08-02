/*<applet code=pongStart width=700 height=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class pongStart extends Applet implements Runnable
{
	int score = 0;
	CompBoard cb;
	PongBall pb;
	Thread th;
	boolean running;
	final int REFRESH_RATE=10;
	Image dbi;
	Graphics dbg;
	boolean hit;
	public void init()
	{
		pb = new PongBall(this);
		cb = new CompBoard(70,10,5,pb,this);
		setBackground(Color.green);
		dbi = createImage(this.getSize().width,this.getSize().height);
		dbg = dbi.getGraphics();
	}
	public void start()
	{
		th = new Thread(this);
		running = true;
		th.start();
	}
	public void run()
	{
		while(running)
		{	
			repaint();
			pb.move();
			cb.move();
		try
		{
			Thread.sleep(REFRESH_RATE);
		}
		catch(Exception e)
		{}
		}
	}
	public void stop()
	{
		running = false;
	}
	public void update(Graphics g)
	{
		dbg.setColor(getBackground());
		dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor (getForeground());
		paint (dbg);
		g.drawImage (dbi, 0, 0, this);
		if(pb.isHit(cb)) score +=10;
		g.drawString("Your Score: "+score,200,40);
	}
	public void paint(Graphics g)
	{
		pb.paint(g);
		cb.paint(g);
		g.setColor(Color.black);
	}
}