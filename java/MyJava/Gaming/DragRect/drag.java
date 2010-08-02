/*<applet code=drag width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
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
	public boolean isInside(int x, int y)
	{
		return(locx<=x && locy<=y && (locx+width >= x) && 				(locy+height >= y));
	}
	public void translate(int x, int y)
	{
		locx = x;
		locy = y;
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
	Image im;
	Graphics g;
	int i=0;
	int clickX,clickY;
	int dragX,dragY;
	Thread t;
	DragRect d;
	boolean running=false;
	public void init()
	{
		t = new Thread(this);
		d = new DragRect(30,40,20,18,Color.black);
		d.setDraggable(true);
		addMouseListener(new MyMouseAdapter(this));
		addMouseMotionListener(this);
		setBackground(Color.cyan);
		im = createImage(500,500);
		g = im.getGraphics();
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
			d.paint(g);
		if(d.isInside(clickX,clickY))
		{
			d.translate(dragX,dragY);
			d.paint(g);
			clickX=dragX;
			clickY=dragY;
		}
		else{}
	}
/*	public void update(Graphics g)
	{
		paint(g);
	}
*/
/* BY OVERRIDING THIS METHOD like this, WE PREVENT THE WHOLE SCREEN FROM BEING CLEARED AND REPAINTED. IF WE DONOT OVERRIDE
 THIS THEN A FLICKERING RECTANGLE WILL COME BUT THERE'D BE NO TRAIL OF THE RECTANGLE WILL APPEAR.
BUT IF WE DO OVERRIDE IT THEN FLICKERING WILL DISAPPEAR BUT A TRAIL WILL BE LEFT.
THIS IS BECAUSE IF WE OVERRIDE IT, THEN IT DOES NOT CLEAR AND REPAINT SIMPLY REPAINTS ON THE PREVIOUS SCREEN.
*/
public void update(Graphics a)
{
	g.setColor(getBackground());
	g.fillRect(0,0,this.getSize().width,this.getSize().height);
	g.setColor(getForeground());
	paint(g);//copies everything to im
	a.drawImage(im,0,0,this);
}
public void stop()
	{
		running = false;
		i=0;	
	}
	public void mouseMoved(MouseEvent me)
	{
		running=true;
	}
	public void mouseDragged(MouseEvent me)
	{
		dragX = me.getX();
		dragY = me.getY();
		setFill(false);
	}
	public void setFill(boolean b)
	{
		d.fill = b;
	}
}
class MyMouseAdapter extends MouseAdapter
{
	int i=0;
	drag d;
	public MyMouseAdapter(drag d)
	{
		this.d = d;
	}
	public void mousePressed(MouseEvent me)
	{
		d.dragX=d.clickX = me.getX();
		d.dragY=d.clickY = me.getY();
	}
	public void mouseReleased(MouseEvent me)
	{
		d.running = true;
		d.setFill(true);
	}
	public void mouseClicked(MouseEvent me)
	{
		d.running=false;
	}
}