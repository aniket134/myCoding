/*<applet code=bounce width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
import JavaPackage.Sprite;
import JavaPackage.Sprite2D;
import JavaPackage.RectSprite;
import JavaPackage.Moveable;
import JavaPackage.BouncingRect;
public class bounce extends Applet implements Runnable
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