/*<applet code=applet26 width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class applet26 extends Applet implements ActionListener,ItemListener
{
	List os,browsers;
	String msg="";
	String s1[];
	public void init()
	{
		os=new List(4,true);
		browsers=new List(4,false);

		add(os);
		add(browsers);

		os.addActionListener(this);
		browsers.addActionListener(this);
		os.addItemListener(this);
		browsers.addItemListener(this);

		os.add("Windows XP");
		os.add("Linux");
		os.add("Solaris");
		os.add("MacOS");

		browsers.add("Firefox");
		browsers.add("Chrome");
		browsers.add("Internet Explorer");
		browsers.add("Netscape");
		browsers.add("Browser01");
		browsers.add("Browser02");
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		repaint();
	}
	public void itemStateChanged(ItemEvent ie)
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		s1=os.getSelectedItems();
		msg="Curent OS: ";
		for(int i=0;i<s1.length;i++)
		{
			msg+=" "+s1[i];
		}
		g.drawString(msg,10,150);
		msg="Current Browser: "+browsers.getSelectedItem();
		g.drawString(msg,10,170);
	}

}