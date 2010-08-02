import java.applet.*;
import java.awt.*;

public class CompBoard
{
	private int locX=20;
	private int locY=100;
	private int length;
	private int width;
	private int speedY;
	private int centerY;
	PongBall pb;
	Applet a;
	private boolean slide;
	public CompBoard(int l, int w, int v, PongBall pb, Applet a)
	{
		length = l;	
		width = w;
		speedY = v;
		this.pb = pb;
		this.a = a;
	}
	public void move()	
	{
		centerY = locY + length/2;
		if(pb.speedXNeg())
		{
			if(centerY > pb.getLocY())
			{
				locY -= speedY;
			}
			if(centerY < pb.getLocY()) locY += speedY;
		}
		else{}
	}
	public int getSize()
	{
		return length;
	}
	public int getLocY()
	{
		return locY;
	}
	public int getLocX()
	{
		return locX;
	}
	public int getXSize()
	{
		return width;
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.magenta);
		g.fillRoundRect(locX,locY,width,length,5,10);
	}
}