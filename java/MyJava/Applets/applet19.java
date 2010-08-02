/*<applet code=applet19 width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
public class applet19 extends Applet
{
	final Font f = new Font("Monospace",Font.BOLD,12);
	public void init()
	{
		setBackground(new Color(150,100,255));
		setForeground(Color.cyan);
	}
	public void paint(Graphics g)
	{
		g.drawString("The First String to be displayed.",250,20);
		g.setFont(f);
		Dimension d = this.getSize();
		g.setColor(Color.magenta);
		g.drawString("Is this visible",50,50);//THIS IS NOT.
		g.drawString("Is this visible",400,450);
		g.setColor(Color.lightGray);
		g.fillRect(0,0,d.width-100,d.height-100);
		g.setColor(Color.black);

		g.drawString("This a test",50,80);
		drawCenteredString("This is Centered.",d.width,d.height,g);
		g.setColor(Color.pink);
		g.drawRect(0,0,d.width-1,d.height-1);
		g.setColor(Color.black);
		g.drawString("Is this visible.",50,150);
	}
	void drawCenteredString(String s, int w, int h, Graphics g)
	{
		FontMetrics fm = g.getFontMetrics();
		int x = (w-fm.stringWidth(s))/2;
		int y = (fm.getAscent()+(h-(fm.getAscent()+fm.getDescent()))/2);
		g.drawString(s,x,y);
	}
}
