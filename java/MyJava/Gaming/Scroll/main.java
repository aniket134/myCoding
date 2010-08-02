/*<applet code=main width=300 height=300></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class main extends Applet implements Runnable
{
	private int speed;
	private int scrollSpeed;
	private int gamePosition;
	private int leftBorder;
	private int rightBorder;
	private Star[] stars;	
	private Ufo ufo;
	Thread th;
	private Image dbImage;
	private Graphics dbg;
	private int x;
	private int y;
	
	public void init()
	{
		setBackground(Color.black);	
		speed = 20;
		scrollSpeed=0;
		gamePosition=300;
		leftBorder=-150;
		rightBorder=440;
		fillStarArray();
		ufo = new Ufo(getImage(getCodeBase(),"Ufo1.gif"),this);
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseMoved(MouseEvent me)
			{
				x = me.getX();	
				y = me.getY();
			}
		});
	}
	public void start()
	{
		th=new Thread(this);	
		th.start();	
	}
	public void stop()
	{
		th.stop();
		th=null;
	}
	public void mouseMove()
	{
		if((x<50 || x>250) && (x!=0))
		{
			if(x<50) scrollSpeed = 1;
			if(x<25) scrollSpeed = 2;
			if(x>250) scrollSpeed = -1;
			if(x>275) scrollSpeed = -2;
		}
		else scrollSpeed=0;
	}
	public void run()
	{
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true)
		{
			mouseMove();
			if(gamePosition<=150 && scrollSpeed>0)
			{
				scrollSpeed = 0;
			}
			else if(gamePosition>=450 && scrollSpeed<0)
			{
				scrollSpeed = 0;
			}
			if(scrollSpeed!=0)
			{
				scrollGame();
			}
			ufo.moveUfo();
			repaint();
			try
			{
				Thread.sleep(speed);
			}
			catch(Exception e)
			{
			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}
	public void fillStarArray()
	{
		stars= new Star[300];	
		for(int i=0;i<100;i++)
		{
			Star star = new Star(i,-1);
			stars[i]=star;
		}
		for(int i=100;i<300;i++)
		{
			Star star = new Star((300 - 2*i),1);
			stars[i]=star;
		}
	}
	public void scrollGame()
	{
		for(int i=0;i<stars.length;i++)
		{
			Star star = stars[i];
			star.scrollStar(scrollSpeed);
			int posX = star.getX();
			if(posX<0 || posX>300)
			{
				star.setInSight(false);
			}
			else
			{
				star.setInSight(true);
			}
		}
		ufo.scrollUfo(scrollSpeed);	
		gamePosition -= scrollSpeed;
		leftBorder += scrollSpeed;
		rightBorder += scrollSpeed;
	}
	public void update(Graphics g)
	{
		if(dbImage==null)
		{
			dbImage= createImage(this.getSize().width,this.getSize().height);
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
		ufo.paintUfo(g);
		g.setColor(Color.blue);
		g.fillRect(leftBorder,0,10,300);
		g.fillRect(rightBorder,0,10,300);
		
		g.setColor(Color.green);
		g.drawString("Game position: " + gamePosition, 20,20);
		g.drawString("Left border: " + leftBorder, 20, 40);
		g.drawString("Right border: " + (rightBorder + 10), 20, 60);
	}
}