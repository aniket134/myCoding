/*<applet code=applet22 width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class applet22 extends Applet implements ActionListener
{
	String msg="";
	Button bList[]=new Button[3];
	public void init()
	{
		Button b1 = new Button("Yes");
		Button b2 = new Button("No");
		Button b3 = new Button("Undecided");
		bList[0]=b1;
		bList[1]=b2;
		bList[2]=b3;
		add(b1);
		add(b2);
		add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		for(int i=0;i<3;i++)
		{
			if(ae.getSource()==bList[i])
				msg = "You pressed "+bList[i].getLabel();
		}
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,10,40);
	}
}