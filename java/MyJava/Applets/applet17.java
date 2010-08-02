/*<applet code=applet17 width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class applet17 extends Applet
{
	int click=0;
	String msg="";
	Font f;
	public void init()
	{
		f = new Font("Dialog",Font.PLAIN,12);
		msg="Dialog";
		setFont(f);
		addMouseListener(new MyMouseFontAdapter(this));
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,4,20);
	}
}
class MyMouseFontAdapter extends MouseAdapter
{
	public MyMouseFontAdapter(applet17 a)
	{
		this.a = a;
	}
	applet17 a;
	public void mousePressed(MouseEvent me)
	{
		a.click++;	
		switch(a.click)
		{
			case 0:
				a.f = new Font("Dialog",Font.PLAIN,12);
				a.msg="Dialog";
				break;
			case 1:
				a.f = new Font("DialogInput",Font.PLAIN,12);
				a.msg="DialogInput";
				break;
			case 2:
				a.f = new Font("SansSerif",Font.PLAIN,12);
				a.msg="SansSerif";
				break;
			case 3:
				a.f = new Font("Serif",Font.PLAIN,12);
				a.msg="Serif";
				break;
			case 4:
				a.f = new Font("Monospaced",Font.PLAIN,12);
				a.msg="Monospaced";
				break;
		}
		if(a.click==4)a.click=-1;
		a.setFont(a.f);
		a.repaint();
	}
}
			