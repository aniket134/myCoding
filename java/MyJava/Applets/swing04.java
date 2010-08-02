/*<applet code=swing04 width=500 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class swing04 extends JApplet implements ItemListener
{
	JTextField txt;
	public void init()
	{
		Container contentPane= getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon home = new ImageIcon("nav_home.jpg");
		ImageIcon next = new ImageIcon("nav_next.jpg");
		ImageIcon prev = new ImageIcon("nav_prev.jpg");
		
		JCheckBox cd = new JCheckBox("A",home);
		cd.setRolloverIcon(next);
		cd.setSelectedIcon(prev);
		cd.addItemListener(this);
		contentPane.add(cd);
		
		cd = new JCheckBox("B",home);
		cd.setRolloverIcon(next);
		cd.setSelectedIcon(prev);
		cd.addItemListener(this);
		contentPane.add(cd);		
		
		cd = new JCheckBox("C",home);
		cd.setRolloverIcon(next);
		cd.setSelectedIcon(prev);
		cd.addItemListener(this);
		contentPane.add(cd);
		
		txt = new  JTextField(15);
		contentPane.add(txt);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		JCheckBox jb = (JCheckBox)ie.getItem();
		txt.setText(jb.getText());
	}
}
		