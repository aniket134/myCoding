//package OT; DOESNOT WORK WITH PACKAGE
/*<applet code=Graph height=400 width=500></applet>*/
import java.applet.*;
import java.awt.*;
public class Graph extends Applet
{
	String stat=null;
	public void init()
	{
		setBackground(Color.black);
		setForeground(Color.white);
		stat="Inside init().";
		add(new Label("label 1"));
	}
	public void start()
	{
		stat+="Inside start().";
	}
	public void paint(Graphics g)
	{
		stat+="Inside paint().";
		g.drawString(stat,50,50);
	}
}