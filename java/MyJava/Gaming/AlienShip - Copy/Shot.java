import java.awt.*;

public class Shot
{
	private int speedY;
	private int x;
	private int y;
	private int radius;
	public Shot(int x, int y)
	{
		this.x=x;
		this.y=y;
		radius=2;
		speedY=2;
	}
	public void moveShot()
	{
		y -=speedY;
	}
	public void paintShot(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillRoundRect(x,y,radius,radius*2,1,1);
	}
	public int getY()
	{
		return y;
	}
}