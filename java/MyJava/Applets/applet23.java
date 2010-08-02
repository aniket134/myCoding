/*<applet code=applet23 width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class applet23 extends Applet implements ItemListener
{
	String msg="";
	Checkbox c1,c2,c3,c4;
	public void init()
	{
		c1 = new Checkbox("Lord Of The Rings",true);
		c2 = new Checkbox("The Departed");
		c3 = new Checkbox("Pirates Of The Caribbean");
		c4 = new Checkbox("Eternal Sunshine Of The Spotless Mind");
		add(c1);
		add(c2);
		add(c3);
		add(c4);
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		c4.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		msg="Current States: ";
		g.drawString(msg,6,100);
		msg=c1.getLabel()+": "+c1.getState();
		g.drawString(msg,6,120);
		msg=c2.getLabel()+": "+c2.getState();
		g.drawString(msg,6,140);
		msg=c3.getLabel()+": "+c3.getState();
		g.drawString(msg,6,160);
		msg=c4.getLabel()+": "+c4.getState();
		g.drawString(msg,6,180);
	}
}