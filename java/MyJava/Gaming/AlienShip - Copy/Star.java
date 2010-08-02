import java.awt.*;
import java.util.*;

public class Star
{
	private int x;
	private int y;
	private int radius;
	private int speedY;
	private int sizeY;

	public Star(int x, int y, int sizeY,int radius)
	{
		this.x=x;
		this.y=y;
		this.sizeY = sizeY;
		this.radius=radius;
		speedY=1;
	}
	public void paintStar(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval(x,y,radius,radius);
	}
	public void moveStar()
	{
		if(y>=sizeY)
		{
			y = 0;
		}
		y +=speedY;
	}
}