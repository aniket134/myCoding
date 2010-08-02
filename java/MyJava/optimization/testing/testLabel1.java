/*<applet code="testLabel1" width=300 height=500></applet>*/

import java.awt.*;
import javax.swing.*;

public class testLabel1 extends JApplet{

	public void init(){

		Container contentPane = getContentPane();
		ImageIcon ii = new ImageIcon("soccer_ball.png");
		JLabel jl = new JLabel("Ball",ii,JLabel.CENTER);
		contentPane.add(jl);
	}
}