import java.util.*;
import java.awt.*;

public class Landscape
{
	private int start;
	private int[] map;
	private Color[] color;
	private int red;
	private int green;
	private int blue;
	private int mapSize;
	private int mapHeight;
	private int change;
	private int factor = 1;
	private int last;
	private int plus;
	private Random rnd =  new Random();
	public Landscape(int a,int b)
	{
		mapSize= a;	
		mapHeight = b;
		map = new int[mapSize];
		color = new Color[mapSize];
		generateLandscape();
	}
	public void generateLandscape()
	{
		plus = 1;
		start = Math.abs(300+(rnd.nextInt() % 50));
		map[0] = start;
		red = Math.abs(rnd.nextInt()%220);
		blue = Math.abs(rnd.nextInt()%220);
		green = 200;
		color[0] = new Color(red,green,blue);
		for(int i=1; i<mapSize;i++)
		{
			last = map[i-1];
			change = Math.abs(rnd.nextInt()%10);
			if(change>8)
			{
				factor *=-1;
				plus = 1 + Math.abs(rnd.nextInt()%2);
			}
			if(last> (mapHeight - (mapHeight/10)) || last< 						(mapHeight/10))
			{
				factor *= -1;
			}
			if(green>240) green -=10;
			if(green<50) green +=10;
			map[i] = last + (factor*plus);
			green += (factor*plus);
			color[i] = new Color(red,green,blue);
		}
	}
	public void paintMap(Graphics g)
	{
		for(int i=0;i<mapSize;i++)
		{
			g.setColor(color[i]);
			g.drawLine(i,map[i],i,mapHeight);
		}
	}
}