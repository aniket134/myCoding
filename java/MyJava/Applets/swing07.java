/*<applet code=swing07 width=500 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class swing07 extends JApplet 
{
	public void init()
	{
	JTabbedPane jtp = new JTabbedPane();
	jtp.addTab("Cities",new CitiesPanel());
	jtp.addTab("Colors",new ColorsPanel());	
	jtp.addTab("Flavors",new FlavorsPanel());
	jtp.addTab("Test",new JCheckBox("Test"));	
	getContentPane().add(jtp);
	}
}
class CitiesPanel extends JPanel implements ActionListener
{
	JTextField jt = new JTextField(15);
	public CitiesPanel()
	{
		JButton a = new JButton("New York");
		JButton b = new JButton("London");
		JButton c = new JButton("Hong Kong");
		JButton d = new JButton("Tokyo");
		add(a);
		add(b);
		add(c);
		add(d);
		add(jt);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		jt.setText(ae.getActionCommand());
	}
}
class ColorsPanel extends JPanel
{
	public ColorsPanel()
	{
		JCheckBox a = new JCheckBox("Red");
		JCheckBox b = new JCheckBox("Purple");
		JCheckBox c = new JCheckBox("Dark Green");
		JCheckBox d = new JCheckBox("Dark Gray");
		add(a);
		add(b);
		add(c);
		add(d);
	}
}
class FlavorsPanel extends JPanel
{
	public FlavorsPanel()
	{
		JComboBox jb = new JComboBox();
		jb.addItem("Vanilla");
		jb.addItem("Chocolate");
		jb.addItem("Black Current");
		add(jb);
	}
}		