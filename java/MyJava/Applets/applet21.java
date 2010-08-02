/*<applet code=applet21 width=500 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class applet21 extends Applet implements ActionListener
{
	String msg="";
	Button b1,b2,b3;
	public void init()
	{
		b1=new Button("Yes");
		b2=new Button("No");
		b3=new Button("Undecided");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		b3.addActionListener(this);
		add(b2);
		add(b3);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		if(str.equals("Yes"))msg="You said Yes!!";
		else if(str.equals("No"))msg="You said No!!";
		else msg="WTF....   You haven't decided yet????!!!!";
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,14,100);
	}
}