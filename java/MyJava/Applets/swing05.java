/*<applet code=swing05 width=500 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class swing05 extends JApplet implements ActionListener
{
	JTextField txt;
	public void init()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JRadioButton a = new JRadioButton("A");
		a.addActionListener(this);
		contentPane.add(a);
		
		JRadioButton b = new JRadioButton("B");
		b.addActionListener(this);
		contentPane.add(b);
		
		JRadioButton c = new JRadioButton("C");
		c.addActionListener(this);
		contentPane.add(c);

		ButtonGroup bt = new ButtonGroup();
		bt.add(a);
		bt.add(b);
		bt.add(c);

		txt = new JTextField(10);
		contentPane.add(txt);
	}
	public void actionPerformed(ActionEvent ae)
	{
		txt.setText(ae.getActionCommand());
	}
}	