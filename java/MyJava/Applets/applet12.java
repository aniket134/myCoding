/*<applet code=applet12 width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
public class applet12 extends Applet
{
	public void paint(Graphics g)
	{
		int x[]={50,450,50,250,450};	
		int y[]={50,450,450,250,50};	
		int num=5;
		g.drawPolygon(x,y,num);
		int sandX[]={150,350,250};
		int sandY[]={150,150,250};
		int sandNum=3;
		g.fillPolygon(sandX,sandY,sandNum);
		int bottomX[]={100,400,450,50};
		int bottomY[]={400,400,450,450};
		int bottomNum=4;
		g.fillPolygon(bottomX,bottomY,bottomNum);
		int fallX[]={250,260,240};
		int fallY[]={250,400,400};
		g.fillPolygon(fallX,fallY,sandNum);
	}
}
/*
   ALL VALUES OF X CORRESPOND TO RESPECTIVE VALUES OF Y.
   ALL VALUES SHPULD BE TAKEN IN A SPECIFIC DIRECTION, EITHER
   CLOCKWISE OR ANTICLOCKWISE, HERE IT IS CLOCKWISE.
*/