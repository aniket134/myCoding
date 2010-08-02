/*<applet code=applet31 width=500 height=500></applet?*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class applet31 extends Applet 
{
	public void init()
	{	
		setBackground(Color.cyan);
		setLayout(new BorderLayout());
		add(new Label("North label"),BorderLayout.NORTH);
		add(new Label("East label"),BorderLayout.EAST);
		add(new Button("West button"),BorderLayout.WEST);
		add(new Button("South button"),BorderLayout.SOUTH);
		String msg ="The reasonable man adapts"+
			" himself to the world.\n"+
			"the unreasonable one persists in "+
			"trying to adapt the world to himself.\n"+
			"Therefore all progress depends "+
			"on the unreasonable man.\n\n"+
			"             -George Bernard Shaw\n\n";
		add(new TextArea(msg,10,10,TextArea.SCROLLBARS_VERTICAL_ONLY),BorderLayout.CENTER);
	}
	public Insets getInsets()
	{
		return new Insets(10,10,10,10);
	}
}