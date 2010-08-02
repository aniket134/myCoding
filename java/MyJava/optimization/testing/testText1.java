/*<applet code=testText1 width=400 height=500></applet>*/
import java.awt.*;
import javax.swing.*;

public class testText1 extends JApplet{
	JTextField jtf;
	String jtfData = null;
	public void init(){

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		jtf = new JTextField(jtfData,15);
		contentPane.add(jtf);
	}
}