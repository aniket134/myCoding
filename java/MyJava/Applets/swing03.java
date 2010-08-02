/*<applet code=swing03 width=500 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class swing03 extends JApplet implements ActionListener
{
	JTextField txt = new JTextField(13);
	public void init()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon nickel = new ImageIcon("nav_home.jpg");
		JButton jb1 = new JButton("Nickelback",nickel);
		jb1.addActionListener(this);
		contentPane.add(jb1);	

		ImageIcon enrique = new ImageIcon("nav_next.jpg");
		JButton jb2 = new JButton("Enrique",enrique);
		jb2.addActionListener(this);
		contentPane.add(jb2);
		
		ImageIcon eminem = new ImageIcon("nav_prev.jpg");
		JButton jb3 = new JButton("Eminem",eminem);
		jb3.addActionListener(this);
		contentPane.add(jb3);
		
		ImageIcon image = new ImageIcon("image.jpg");
		JButton jb4 = new JButton("Image",image);
		jb4.addActionListener(this);
		contentPane.add(jb4);
		
		contentPane.add(txt);
	}
	public void actionPerformed(ActionEvent ae)
	{	
		txt.setText(ae.getActionCommand());
	}
}
		