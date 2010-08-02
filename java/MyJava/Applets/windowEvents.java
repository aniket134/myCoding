/*<applet code=windowEvents height=100 width=300></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
class SampleFrame extends Frame implements MouseListener,MouseMotionListener
{
	String msg="";
	int mouseX=0,mouseY=10;
/*THE init(), start(), stop(), etc. ARE APPLET'S FUNCTION NOT FRAME'S.*/
	SampleFrame(String title)
	{
		super(title);
		addMouseListener(this);
		addMouseMotionListener(this);
		MyWindowAdapter m = new MyWindowAdapter(this);
		addWindowListener(m);
		msg="Frame initiated";
		repaint();
	}
	public void mouseClicked(MouseEvent me)
	{
		mouseX=0;
		mouseY=10;
		msg="Mouse has been Clicked.";
		repaint();
	}
	public void mouseEntered(MouseEvent me)
	{
		mouseX=0;
		mouseY=10;
		msg="Mouse has Entered.";
		repaint();
	}
	public void mouseExited(MouseEvent me)
	{
		mouseX=0;
		mouseY=10;
		msg="Mouse has Exited.";
		repaint();
	}
	public void mousePressed(MouseEvent me)
	{
		mouseX=me.getX();
		mouseY=me.getY();
		msg="Mouse has been Pressed.";
		repaint();
	}
	public void mouseReleased(MouseEvent me)
	{
		mouseX=me.getX();
		mouseY=me.getY();
		msg="Mouse has been Released.";
		repaint();
	}
	public void mouseMoved(MouseEvent me)
	{
		msg="*";
		mouseX=me.getX();
		mouseY=me.getY();
		repaint(0,0,100,100);
	}
	public void mouseDragged(MouseEvent me)
	{
		msg="*";
		mouseX=me.getX();
		mouseY=me.getY();
		repaint(0,0,100,100);
	}
	public void paint(Graphics g)
	{	
		g.drawString(msg,mouseX,mouseY);
	}
}
class MyWindowAdapter extends WindowAdapter
{
	public MyWindowAdapter(SampleFrame s)
	{
		this.s = s;
	}
	SampleFrame s;
	public void windowClosing(WindowEvent we)
	{
		s.setVisible(false);
	}
}
public class windowEvents extends Applet
{
	SampleFrame s;
	public void init()
	{
		s = new SampleFrame("A Frame Window");
		s.setSize(200,300);
		s.setVisible(true);
	}
	public void start()
	{
		s.setVisible(true);
	}
	public void stop()
	{
		s.setVisible(false);
	}
}