import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JWindow;


public class JWindowTest extends JWindow {
	public void init()
	{
		JTextField jtf;
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		jtf = new JTextField("Your Name",5);
		//THE SECOND PARAMETER DECIDES THE SIZE OF THE TEXT FIELD SHOWN.
		//NOT THE LENGTH OF TEXT POSSIBLE
		jtf.select(0,jtf.getText().length());
		contentPane.add(jtf);
	}
}
