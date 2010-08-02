import java.awt.*;
import java.util.*;

public class Star
{
	private int x;
	private int y;
	private int radius;
	private int scrollSpeed;
	private boolean inSight;
	private Random rnd;
	public Star(int array_index, int signum)
	{
		rnd= new Random();
		x=signum*Math.abs(rnd.nextInt()%(150-array_index));
		y=signum*Math.abs(rnd.nextInt()%(150-array_index/4));
		radius=2;
		inSight=true;
	}	
	public int getX()
	{
		return x;
	}
	public void scrollStar(int speed)
	{
		x+=speed;
	}
	public void setInSight(boolean b)
	{
		inSight = b;
	}
	public void paintStar(Graphics g)
	{
		if(inSight)
		{
			g.setColor(Color.white);
			g.fillOval(x,y,radius,radius);	
		}
	}
}