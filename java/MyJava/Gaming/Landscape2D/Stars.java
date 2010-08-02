import java.util.*;
import java.awt.*;

public class Stars
{
	private int numStars = 70;	
	private int mapSize;
	private int[] x= new int[numStars];
	private int[] y= new int[numStars];
	Random rnd = new Random();
	private int radius=2;
	private int starZone;
	public Stars(int a)
	{
		mapSize = a;
		starZone = a/2;
		generateStars();
	}
	public void generateStars()
	{
		for(int i=0;i<numStars;i++)
		{
			x[i] = Math.abs(rnd.nextInt()%mapSize);
			y[i] = Math.abs(rnd.nextInt()%starZone);
		}
	}
	public void paintStars(Graphics g)
	{
		g.setColor(Color.white);	
		for(int i=0;i<numStars;i++)
		{
			g.drawOval(x[i],y[i],radius,radius);
		}
	}
}