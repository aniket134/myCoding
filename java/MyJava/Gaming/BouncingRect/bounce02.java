/*<applet code=bounce02 width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
public class bounce02 extends Applet implements Runnable
{
	Thread animation;
	Graphics offscreen;
	Image image;
	static final int NUM_SPRITES=3;
	static final int REFRESH_RATE=50;
	
	Sprite sprites[];
	int w,h;
	boolean running=false;
	public void init()
	{
		System.out.println(">> init <<");
		setBackground(Color.black);
		initSprites();
		w = Integer.parseInt(getParameter("width"));
		h = Integer.parseInt(getParameter("height"));
		System.out.println(w+", "+h);
		image = createImage(500,500);
		offscreen = image.getGraphics();
	}
	public void initSprites()
	{
		sprites = new Sprite[NUM_SPRITES];
		sprites[0] = new RectSprite(0,0,w-1,h-1,Color.green);
		sprites[1] = new BouncingRect(10,40,60,30,Color.yellow,w-1,h-1);
		sprites[2] = new BouncingRect(17,17,13,13,Color.red,w-1,h-1);
		((Moveable)sprites[1]).setVelocity(4,3);
		((Moveable)sprites[2]).setVelocity(1,2);
		((Sprite2D)sprites[2]).setFill(true);
	}
	public void start()
	{
		running=true;
		System.out.println(">> start <<");
		animation=new Thread(this);
		if(animation!=null)animation.start();
	}
	public void updateSprites()
	{
		for(int i=0;i<sprites.length;i++)
		{
			sprites[i].update();
		}
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public void paint(Graphics g)
	{
		offscreen.setColor(Color.black);
		offscreen.fillRect(0,0,w,h);
		for(int i=0;i<sprites.length;i++)
		{
			sprites[i].paint(offscreen);
		}
		g.drawImage(image,0,0,this);	
	}
	public void run()
	{	
		while(running)
		{
			repaint();
			updateSprites();
			try
			{
				Thread.sleep(REFRESH_RATE);
			}
			catch(Exception e)
			{	}
		}
	}
	public void stop()
	{
		System.out.println(">> stop <<");
		if(animation!=null)
		{
			running=false;	
		}
	}
}
abstract class Sprite
{
	protected boolean visible;
	protected boolean active;
	public abstract void paint(Graphics g);
	public abstract void update();
	public boolean isVisible()
	{
		return visible;
	}
	public void setVisible(boolean b)
	{
		visible = b;
	}
	public boolean isActive()
	{
		return active;
	}
	public void setActive(boolean b)
	{
		active = b;
	}
	public void suspend()
	{
		setVisible(false);
		setActive(false);
	}
	public void restore()
	{
		setVisible(true);
		setActive(true);
	}
}
abstract class Sprite2D extends Sprite
{
	protected int locx;
	protected int locy;
	Color color;
	boolean fill;
	public boolean getFill()
	{
		return fill;
	}
	public void setFill(boolean b)
	{
		fill=b;
	}
	public void setColor(Color c)
	{
		color=c;
	}
	public Color getColor()
	{
		return color;
	}
}
class RectSprite extends Sprite2D
{
	protected int width,height;
	public RectSprite(int x, int y, int w, int h, Color c)
	{
		locx = x;
		locy = y;
		width = w;
		height = h;
		color = c;
		fill = false;
		restore();
	}
	public void update()
	{
	}
	public void paint(Graphics g)
	{
		if(visible)
		{
			g.setColor(color);
			if(fill)
			{
				g.fillRect(locx,locy,width,height);
			}
			else
			{
				g.drawRect(locx,locy,width,height);
			}
		}
	}
}
interface Moveable
{
	public abstract void setPosition(int x, int y);
	public abstract void setVelocity(int x, int y);
	public abstract void updatePosition();
}
class BouncingRect extends RectSprite implements Moveable
{
	protected int max_width;
	protected int max_height;
	protected int vx= 2;
	protected int vy= 2;
	public BouncingRect(int x,int y, int w,int h,Color c,int max_w,int max_y)
	{
		super(x,y,w,h,c);
		max_width=max_w;
		max_height=max_y;
	}
	public void setPosition(int x, int y)
	{
		locx = x;
		locy = y;
	}
	public void setVelocity(int x, int y)	
	{
		vx = x;
		vy = y;	
	}
	public void updatePosition()
	{
		locx += vx;
		locy +=vy;		
	}
	public void update()
	{
		if((locx+width>500) || locx<0)
		{
			vx = -vx;
		}
		if((locy+height>500) || locy<0)
		{
			vy = -vy;
		}
		updatePosition();	
	}
}

