import java.net.*;
import java.awt.*;
import java.applet.*;
import java.util.*;

public class MyBall
{
	private int radius;
	private Color color;
	private int speedX;
	private int speedY;
	private int maxspeed;
	private int locX;
	private int locY;
	private int initX;
	private int initY;
	private int left;
	private int right;
	private int bottom;
	private int top;
	Player player;
	AudioClip out;
	Random rnd = new Random();
	public MyBall(int radius, int x, int y, int vx, int vy, int ms, Color c, Player p, AudioClip out, Applet a)
	{
		this.radius = radius;
		initX = locX = x;
		initY = locY = y;
		speedX = vx;
		speedY = vy;
		color = c;
		player = p;
		this.out = out;
		maxspeed = ms;
		left = 0;
		top = 0;
		right = a.getSize().width;
		bottom = a.getSize().height;
	}
	public boolean isHit(int x, int y)
	{
		double dX = x-locX-radius;
		double dY = y-locY-radius;
		double d = Math.sqrt((dX)*(dX) - (dY)*(dY));
		if(d<radius) 
		{
			player.setScore(10*Math.abs(speedX) + 10);
			return true;
		}
		else return false;
	}
	public boolean isOut()
	{
		if (locX<left || locX>right || locY<top || locY>bottom)
		{
			locX = initX;	
			locY = initY;
			out.play();
			player.killLife();
			speedX = (rnd.nextInt()) % maxspeed;
			speedY = (rnd.nextInt()) % maxspeed;
			return true;
		}
		else return false;
	}
	public void move()
	{
		if(speedX == 0)speedX = 2;
		if(speedY == 0)speedY=2;
		locX += speedX;
		locY += speedY;
		isOut();
	}
	public void ballWasHit()
	{
		locX = initX;	
		locY = initY;
		speedX = (rnd.nextInt()) % maxspeed;
		speedY = (rnd.nextInt()) % maxspeed;	
	}
	public void paint(Graphics g)
	{
		g.setColor(color);
		g.fillOval(locX-radius , locY-radius, 2*radius, 2*radius);
	}
}