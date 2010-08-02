/*<applet code=main width=700 height=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.net.*;
import java.awt.event.*;
public class main extends Applet implements Runnable
{
	Thread th;
	private int speed;
	Random rnd = new Random();
	Landscape land;
	Stars stars;
	private Image dbImage;
	private int width,height;
	private Graphics dbg;
	public void init()
	{
		width = this.getSize().width;
		height = this.getSize().height;
		speed = 20;
		setBackground(Color.black);
		land = new Landscape(this.getSize().width,this.getSize().height);
		stars = new Stars(this.getSize().width);
		dbImage = createImage(this.getSize().width,this.getSize().height);
		dbg = dbImage.getGraphics();
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				land = new Landscape(width,height);
				stars = new Stars(width);
				repaint();
			}
		});		
		repaint();
	}
	public void start()
	{
		th = new Thread(this);
		th.start();
	}
	public void stop()
	{
		th.stop();
	}
	public void run()
	{
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true)
		{
			repaint();
			try
			{	
				Thread.sleep(speed);
			}
			catch(Exception e)
			{break;}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.yellow);
		g.drawString("Click on Applet for a brand new Landscape.",100,50);
		stars.paintStars(g);	
		land.paintMap(g);
	}
	public void update(Graphics g)
	{
		dbg.setColor(getBackground());
		dbg.fillRect(0,0,this.getSize().width,this.getSize().height);
		dbg.setColor(getForeground());
		paint(dbg);
		g.drawImage(dbImage,0,0,this);
	}
}