import java.util.*;
import java.applet.*;
import java.awt.*;
public class Ufo
{
	public boolean inSight;
	private int x;
	private int y;
	
	private int speedX;
	
	private Applet a;
	private Image ufo_image;
	
	public Ufo(Image ufo_image,Applet a)
	{
		this.a=a;
		this.ufo_image = ufo_image;
		x=-20;	
		y=130;
		speedX=1;
		inSight=true;
	}
	public void setInSight(boolean b)
	{
		inSight=b;
	}
	public void paintUfo(Graphics g)
	{
		if(inSight)
		{
			g.drawImage(ufo_image,x,y,a);
		}
	}
	public void scrollUfo(int speed)
	{
		x+=speed;
	}
	public void moveUfo()
	{
		x+=speedX;
		if(x>350)
		{
			x=-50;
		}
	}
}