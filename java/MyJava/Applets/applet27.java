/*<applet code=applet27 width=500 height=500></applet>*/
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class applet27 extends Applet implements AdjustmentListener,MouseMotionListener
{
	String msg="";
	Scrollbar  ver,hor;	
	public void init()
	{	
		int width = Integer.parseInt(getParameter("width"));
		int height = Integer.parseInt(getParameter("height"));
		ver = new Scrollbar(Scrollbar.VERTICAL, 0,10,0,height);
		hor = new Scrollbar(Scrollbar.HORIZONTAL,0,10,0,width);
		add(ver);
		add(hor);
		ver.addAdjustmentListener(this);
		hor.addAdjustmentListener(this);
		addMouseMotionListener(this);
	}
	public void mouseMoved(MouseEvent me)
	{
	}
	public void mouseDragged(MouseEvent me)
	{
		ver.setValue(me.getY());
		hor.setValue(me.getX());
		repaint();
	}
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		msg="Vertical: "+ver.getValue();
		msg+="Horizontal: "+hor.getValue();
		g.drawString(msg,10,50);
		g.drawString("*",hor.getValue(),ver.getValue());
	}
}