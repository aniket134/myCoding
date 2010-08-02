/*<applet code=keyEvents height=100 width=300></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class keyEvents extends Applet implements KeyListener
{	
	String msg="";
	int a=0;
	int X=10,Y=20;
	public void init()
	{
		addKeyListener(this);
		requestFocus();
	}
	public void keyPressed(KeyEvent ke)
	{
		showStatus("Key Down.");
		a = ke.getKeyCode();
		switch(a)
		{
			case KeyEvent.VK_F1:
				msg += "<F1>";
				break;
			case KeyEvent.VK_F2:
				msg += "<F2>";
				break;
			case KeyEvent.VK_F3:
				msg += "<F3>";
				break;
			case KeyEvent.VK_PAGE_DOWN:
				msg += "<PgDn>";
				break;
			case KeyEvent.VK_PAGE_UP:
				msg += "<PgUp>";
				break;
			case KeyEvent.VK_LEFT:
				msg += "<Left Arrow>";
				break;
			case KeyEvent.VK_RIGHT:
				msg += "<Right Arrow>";
				break;
		}
		repaint();
	}
	public void keyReleased(KeyEvent ke)
	{
		showStatus("Key released.");
		repaint();
	}
	public void keyTyped(KeyEvent ke)
	{
		msg +=ke.getKeyChar();
		repaint();
	}	
	public void paint(Graphics g)
	{
		g.drawString(msg,X,Y);
	}
}