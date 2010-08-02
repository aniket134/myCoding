/*<applet code=applet32 width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class applet32 extends Applet
{
	public void init()
	{
		setLayout(new GridLayout(4,4));
		setFont(new Font("Monospaced",Font.BOLD,24));
		for(int i =0;i<15;i++)add(new Button(""+(i+1)));
	}
}