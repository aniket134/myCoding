/*<applet code=applet24 width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class applet24 extends Applet implements ItemListener
{
	String msg;
	Checkbox a,s,d,f;
	CheckboxGroup cg;
	public void init()
	{
		cg = new CheckboxGroup();
		a=new Checkbox("Maybe sometimes there just aren't enough stones to throw.",cg,true);
		s=new Checkbox("What am I doin here?",cg,false);
		d=new Checkbox("I'm just running blindfolded",cg,false);
		f=new Checkbox("Why is it always all clouded",cg,false);
		add(a);
		add(s);
		add(d);
		add(f);
		a.addItemListener(this);
		s.addItemListener(this);
		d.addItemListener(this);
		f.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		msg="You are thinking: ";
		msg+=cg.getSelectedCheckbox().getLabel();
		g.drawString(msg,10,100);
	}
}