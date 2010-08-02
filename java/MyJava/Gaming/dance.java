/*<applet code=dance width=500 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
class DancingRect
{
	public DancingRect(int locx,int locy, int width, int height, Color mycolor)
	{
		this.locx=locx;
		this.locy=locy;
		this.width=width;
		this.height=height;
		this.mycolor=mycolor;
	}	
	int locx,locy,width,height;
	Color mycolor;
	byte state=0;
	public void danceStep()
	{
		switch (state)
		{
		case 0:
			locy += 2;
			if ((locy+height) >= 499) 
			{
				state = 1;
			}
			break;
		case 1:
			locy -= 2;
			if (locy <= 1) 
			{
				state = 2;
			}
			break;
		case 2:
			locx += 2;
			if ((locx+width) >=499 ) 
			{
				state = 3;
			}
			break;
		case 3:
			locx -= 2;
			if (locx <= 1) 
			{
				state = 0;
			}
			break;
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(mycolor);
		g.fillRect(locx,locy,width,height);
	}
}
public class dance extends Applet implements Runnable
{
	Thread animation;
	Graphics offscreen;
	Image image;
	static final int REFRESH_RATE=100;
	static final int NUM_RECTS=9;
	DancingRect r[];
	public void init()
	{
		setBackground(Color.black);
		initRectangles();
		image = createImage(500,500);
		offscreen = image.getGraphics();
	}
	public void initRectangles()
	{
		r=new DancingRect[NUM_RECTS];
	r[0]=new DancingRect(0,0,40,40,Color.yellow);
	r[1]=new DancingRect(400,300,90,90,Color.yellow);
	r[2]=new DancingRect(700,200,90,90,Color.yellow);
	r[3]=new DancingRect(105,200,90,90,Color.blue);
	r[4]=new DancingRect(300,100,90,90,Color.blue);
	r[5]=new DancingRect(0,300,90,90,Color.lightGray);
	r[6]=new DancingRect(200,50,90,50,Color.red);
	r[7]=new DancingRect(360,400,50,90,Color.red);
	r[8]=new DancingRect(230,300,45,45,Color.magenta);
	}
	public void start()
	{
		animation = new Thread(this);
		if(animation !=null)
		{
			animation.start();
		}
	}
	public void updateRect()
	{
		for(int i=0;i<NUM_RECTS;i++)
		{
			r[i].danceStep();
		}
	}
	public void update(Graphics g)
	{
		paint(g);	
	}
	public void paint(Graphics g)
	{
		offscreen.setColor(Color.black);
		offscreen.fillRect(0,0,500,500);
		for(int i=0;i<NUM_RECTS;i++)
		{
			r[i].paint(offscreen);
		}
		g.drawImage(image,0,0,this);
	}
	public void run()
	{
		while(true)
		{
			repaint();
			updateRect();
			try
			{
				Thread.sleep(REFRESH_RATE);
			}
			catch(Exception e)
			{
			}
		}
	}
	public void stop()
	{
		System.out.println(">> Stop <<");
		animation.stop();
		animation=null;
	}
}