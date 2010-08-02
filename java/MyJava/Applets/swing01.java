/*<applet code=swing01 width=500 height=500></applet>*/
import java.awt.*;
import javax.swing.*;
public class swing01 extends JApplet
{
	public void init()
{
	Container contentPane = getContentPane();
	ImageIcon ii = new ImageIcon("image.jpg");
	JLabel jl = new JLabel("This is an image.",ii,JLabel.CENTER);
//WHOLE LABEL SHIFTS RIGHT OR LEFT OR CENTER
	contentPane.add(jl);
}
}