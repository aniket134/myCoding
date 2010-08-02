/*<applet code=applet30 width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class applet30 extends Applet implements ItemListener
{
	Checkbox win,mac,linux,solaris;
	String msg="";
	public void init()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT));
		win= new Checkbox("Windows XP",true);
		mac= new Checkbox("Macintosh");
		linux= new Checkbox("Linux");
		solaris= new Checkbox("Solaris");
		add(win);
		add(mac);
		add(linux);
		add(solaris);
		win.addItemListener(this);
		mac.addItemListener(this);
		linux.addItemListener(this);
		solaris.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		msg="Current OS state: ";
		g.drawString(msg,6,80);
		msg=" Windows XP: "+win.getState();
		g.drawString(msg,6,100);
		msg=" Macintosh: "+mac.getState();
		g.drawString(msg,6,120);
		msg=" Linux: "+linux.getState();
		g.drawString(msg,6,140);
		msg="Solaris: "+solaris.getState();	
		g.drawString(msg,6,160);		
	}
}