/*<applet code=applet25 width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class applet25 extends Applet implements ItemListener
{	
	String msg="";
	Choice sports,field;
	public void init()
	{
		sports = new Choice();
		field = new Choice();
		
		sports.add("Badminton");
		sports.add("Tennis");
		sports.add("Cricket");
		sports.add("Football");
		sports.add("Wrestling");
		
		field.add("Rectangle");
		field.add("Square");
		field.add("Oval");
		field.add("Circle");
		
		add(sports);
		add(field);
		
		sports.addItemListener(this);
		field.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		msg="Selected Sport is: "+sports.getSelectedItem();
		g.drawString(msg,5,100);
		msg="Selected field is: "+field.getSelectedItem();
		g.drawString(msg,5,120);
	}
}