/*FOR SOME REASON mouseMoved DOESNOT WORK*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class windowProg extends Frame
{	
	String msg="This is a Test Program.",kmsg="This is a Test Prog.";
	int mouseX=0,mouseY=10;
	public windowProg()
	{
		addKeyListener(new MyKeyAdapter(this));
		addMouseListener(new MyMouseAdapter(this));
		addWindowListener(new MyWindowClosingAdapter());
	}	
	public void paint(Graphics g)
	{
		g.drawString(kmsg,10,40);
		g.drawString(msg,mouseX,mouseY);
	}
	public static void main(String args[])
	{	
		windowProg WP = new windowProg();
		WP.setSize(new Dimension(300,400));
		WP.setTitle("This is a Window.");
		WP.setVisible(true);
	}
}	
class MyKeyAdapter extends KeyAdapter
{	
	windowProg Wp;
	public MyKeyAdapter(windowProg wp)
	{
		Wp = wp;
	}
	public void keyTyped(KeyEvent ke)
	{
		Wp.kmsg+=ke.getKeyChar();
		Wp.repaint();
	}
}	
class MyMouseAdapter extends MouseAdapter
{	
	windowProg wp;
	public MyMouseAdapter(windowProg wp)
	{
		this.wp = wp;
	}
	public void mouseMoved(MouseEvent me)
	{
		wp.mouseX=me.getX();
		wp.mouseY=me.getY();
		wp.msg="Mouse moving at: "+wp.mouseX+", "+wp.mouseY;
		wp.repaint();
	}
	public void mousePressed(MouseEvent me)
	{
		wp.mouseX=me.getX();
		wp.mouseY=me.getY();
		wp.msg="Down "+wp.mouseX+", "+wp.mouseY;
		wp.repaint();
	}
}	
class MyWindowClosingAdapter extends WindowAdapter
{	
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}	