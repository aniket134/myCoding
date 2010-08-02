/*<applet code=drag width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
import awt.event.*;
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
class DragRect extends RectSprite
{
	protected boolean draggable;
	public void setDraggable(boolean b)
	{
		draggable=b;
	}
	public boolean isDraggable()
	{
		return draggable;	
	}
	public void isInside(int x, int y)
	{
		return(locx<=x && locy<=y && (locx+width >= x) && 				(locy+height >= y);
	}
	public translate(int x, int y)
	{
		locx += x;
		locy += y;
	}
	public DragRect(int x, int y, int w, int h, Color c)
	{
		super(x,y,w,h,c);
		fill=true;
		draggable=false;
	}
}
public class drag extends Applet implements Runnable,MouseMotionListener
{
	int x,y;
	Thread t;
	DragRect d;
	boolean running=false;
	public void init()
	{
		t = new Thread(this);
		d = new DragRect(30,40,200,180,Color.green);
		d.setDraggable(true);
		addMouseListener(new MyMouseAdapter(this));
		addMouseMotionListener(this);		
	}
	public void start()
	{
		running = true;
		t.start();
	}
	public void run()
	{
		while(running)
		{
			repaint();
		}
	}
	public void paint(Graphics g)
	{
		if(d.isInside(x,y))
		{
			d.translate(x,y);
			d.paint(g);
		}
		else{}
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public void stop()
	{
		running = false;
	}
	public void mouseMoved(MouseEvent me)
	{
	}
	public void MouseDragged(MouseEvent me)
	{
		x = me.getX();
		y = me.getY();
	}
}
class MyMouseAdapter extends MouseAdapter
{
	drag d;
	public MyMouseAdapter(drag d)
	{
		this.d = d;
	}
	public void mousePressed(MouseEvent me)
	{
	}
}