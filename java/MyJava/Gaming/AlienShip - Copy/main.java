/*<applet code=main width=700 height=400></applet>*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;

public class main extends Applet implements Runnable
{
	private Thread th;
	private Player player;
	private Shot shot[];
	private Image dbImage;
	private Graphics dbg;
	private int x;
	
	
	private int width;
	private int height;
	
	public void init()
	{
		setBackground(Color.black);
		player = new Player(this.getSize().width,this.getSize().height);
		shot = new Shot[5];
		x=0;
		
		width = this.getSize().width;
		height = this.getSize().height;
		
		
		
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
			for(int i=0;i<shot.length;i++)
			{
				if(shot[i]!=null)
				{
					shot[i].moveShot();
					if(shot[i].getY() <0)
					{
						shot[i] = null;
					}
				}
			}
			if(x<100){
				player.moveLeft();
				x++;
			}
			else{
				if(x<200){
					player.moveRight();
					x++;
				}
				else{
					x=0;
				}
			}
			
			repaint();
			try
			{
				Thread.sleep(10);
			}
			catch(InterruptedException e)
			{}	
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}
	public void update(Graphics g)
	{
		if(dbImage == null)
		{
			dbImage = createImage(this.getSize().width,this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0,0,this.getSize().width,this.getSize().height);
		dbg.setColor(getForeground());
		paint(dbg);
		g.drawImage(dbImage,0,0,this);
	}
	public void paint(Graphics g)
	{
		for(int i=0;i<shot.length;i++)
		{
			if(shot[i]!=null)
			{
				shot[i].paintShot(g);
			}
		}
		player.paintPlayer(g);
	}
}