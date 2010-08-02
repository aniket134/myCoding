import java.util.*;
import java.awt.*;
import java.applet.*;
public class PongBall
{
	private int locX;
	private int locY;
	private int radius = 10;
	private int speedX;
	private int speedY;
	private int left=30;
	private int top=0;
	private int right;
	private int bottom;
	Random rnd = new Random();
	public void paint(Graphics g)
	{
		g.setColor(new Color(155,85,255));
		g.fillOval(locX-radius,locY-radius,2*radius,2*radius);
	}
	public void move()
	{
		if(speedX == 0) 
		{
			speedX = 3;
			locX += speedX;	
		}
		else locX += speedX;
		if(speedY == 0) 
		{
			speedY = 3;
			locY += speedY;
		}
		else locY += speedY;
		isOut();
	}
	public void isOut()
	{
		if(locX<=left)
			speedX *= -1;
		if(locX>=right)
			speedX *= -1;
		if(locY<=top)
			speedY *= -1;
		if(locY>=bottom)
			speedY *= -1;
	}
	public boolean speedXNeg()
	{
		if(speedX<0) return true;
		else return false;
	}
	public int getLocY()
	{
		return locY;
	}
	public boolean isHit(CompBoard computer)
	{
		int ball_top = locY;
		int ball_bottom = locY + 2*radius;
		int ball_left = locX;
		int ball_right = locX + 2*radius;
		int comp_top = computer.getLocY();
		int comp_bottom = computer.getLocY() + computer.getSize();
		int comp_right = computer.getLocX() + computer.getXSize();

		if ((ball_top >= comp_top - radius) && (ball_bottom <= comp_bottom + radius))
		{
			if (ball_left <= (comp_right+10))
			{
				speedX = - speedX;
				return true;
			}
			else return false;
		}
		else return false;
	}

	public PongBall(Applet a)
	{
		locX=(a.getSize().width)/2 - radius;
		locY=(a.getSize().height)/2 - radius;
		speedX =  4;
		speedY = 4;
		right = (a.getSize().width) - radius;
		bottom = (a.getSize().height) - radius;
		top = radius;
		left=25+radius;
	}
}