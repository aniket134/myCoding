/*<applet code=swing02 width=500 height=500></applet>*/
import java.awt.*;
import javax.swing.*;
public class swing02 extends JApplet
{
	JTextField jtf;
	public void init()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		jtf = new JTextField("Your Name",5);
//THE SECOND PARAMETER DECIDES THE SIZE OF THE TEXT FIELD SHOWN.
//NOT THE LENGTH OF TEXT POSSIBLE
		jtf.select(0,jtf.getText().length());
		contentPane.add(jtf);
	}
}