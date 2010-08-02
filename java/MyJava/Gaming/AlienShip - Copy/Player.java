import java.awt.*;
import java.applet.*;

public class Player
{
	private int x;
	private int y;
	private int speedX;
	public Player(int X, int Y)
	{
		x=X/2  - 10;
		y=Y-35;
		speedX=4;
	}
	public void moveRight()
	{
		x +=speedX;
	}
	public void moveLeft()
	{
		x-=speedX;
	}
	public Shot generateShot()
	{
		Shot shot = new Shot(x+10,y);
		return shot;
	}
	public void paintPlayer(Graphics g)
	{
		int xPoints[] = {x,x+10,x+20,x+20,x};
		int yPoints[] = {y+10,y,y+10,y+30,y+30};
		g.setColor(Color.cyan);
		g.fillPolygon(xPoints,yPoints,5);
	}
}