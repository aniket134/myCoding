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
	private Star stars[];
	private Random rnd;
	private int width;
	private int height;
	
	public void init()
	{
		setBackground(Color.black);
		player = new Player(this.getSize().width,this.getSize().height);
		shot = new Shot[5];
		stars = new Star[200];
		width = this.getSize().width;
		height = this.getSize().height;
		rnd = new Random();
		fillStarArray();
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke)
			{
				int key = ke.getKeyCode();
				if(key == KeyEvent.VK_LEFT)
				{
					player.moveLeft();
				}
				if(key == KeyEvent.VK_RIGHT)
				{
					player.moveRight();
				}
				if(key == KeyEvent.VK_SPACE)
				{
					for(int i=0;i<shot.length;i++)
					{
						if(shot[i]==null)
						{
							shot[i]=player.generateShot();
							break;
						}
					}
				}
			}
		});
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
	public void fillStarArray()
	{
		for(int i=0;i<stars.length;i++)
		{
			int x = Math.abs(rnd.nextInt()%width);
			int y = Math.abs(rnd.nextInt()%height);
			int radius = ((rnd.nextInt()) % 3);
			if(radius<=0) 
			{
				radius=2;
			}
			Star star = new Star(x,y,height,radius);
			stars[i] = star;
		}
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
			for(int i=0;i<stars.length;i++)
			{
				stars[i].moveStar();
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
		for(int i=0;i<stars.length;i++)
		{
			stars[i].paintStar(g);
		}
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