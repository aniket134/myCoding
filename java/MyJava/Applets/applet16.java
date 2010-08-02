/*
	setColor() METHOD CHANGES THE DEFAULT COLOR OF THE APPLET 
	SO IT NEEDS TO BE CHANGED TO WHITE BEFORE CALLING THE 		setXORMode() AS IT ALTERS THE COLOR AS PER THE DEFAULT COLOR 	IN APPLET.
*/
	
/*<applet code=applet16 width=500 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class applet16 extends Applet
{
	int crossX=0,crossY=0;
	public void init()
	{
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseMoved(MouseEvent me)
			{
				crossX=me.getX()-10;
				crossY=me.getY()-10;
				repaint();
			}
		});
	}
	public void paint(Graphics g)
	{
		g.setColor(new Color(100,100,200));
		g.fillRect(400,400,100,100);
		g.setColor(new Color(222,222,222));
		g.fillRoundRect(150,150,200,200,10,10);
		g.setColor(Color.blue);
		g.fillOval(10,10,100,100);
		g.setColor(Color.black);
		g.fillRect(200,200,100,100);
		g.setColor(Color.white);
		g.setXORMode(Color.blue);
		g.drawLine(crossX-10,crossY,crossX+10,crossY);
		g.drawLine(crossX,crossY-10,crossX,crossY+10);
		g.setPaintMode();/*DOESNOT RETURN TO PAINT MODE*/
		g.setColor(Color.black);
		g.fillOval(10,300,70,70);
		g.setColor(new Color(250,80,255));
		g.fillArc(300,10,70,70,0,120);
	}
}