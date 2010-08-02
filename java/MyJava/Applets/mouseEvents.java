/*<applet code=mouseEvents height=100 width=300></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class mouseEvents extends Applet implements MouseListener,MouseMotionListener
{
	String msg="";
	int mouseX=0,mouseY=10;
	public void init()
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		msg="Applet initiated";
		repaint();
	}
	public void start()
	{
		msg="Applet started.";
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
		showStatus("Moving mouse at ("+me.getX()+", "+me.getY()+").");
		repaint();
	}
	public void mouseDragged(MouseEvent me)
	{
		msg="*";
		showStatus("Dragging mouse at ("+me.getX()+", "+me.getY()+").");
		repaint();
	}
	public void paint(Graphics g)
	{	
		g.drawString(msg,mouseX,mouseY);
	}
}