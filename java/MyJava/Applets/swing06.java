/*<applet code=swing06 width=500 height=500></applet>*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class swing06 extends JApplet implements ItemListener
{
	JLabel jl;
	public void init()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JComboBox jc = new JComboBox();
		jc.addItem("Next");
		jc.addItem("Prev");
		jc.addItem("Home");
		jc.addItemListener(this);
		contentPane.add(jc);
		
		jl = new JLabel("",new ImageIcon("nav_home.jpg"),JLabel.RIGHT);
		contentPane.add(jl);
	}
	public void itemStateChanged(ItemEvent ie)
	{	
		String s = (String)ie.getItem();
		jl.setText(s);
		s= s.toLowerCase();
		jl.setIcon(new ImageIcon("nav_"+s+".jpg"));
	}
}
/*  
    NO NEW MEMORY CAN BE ALLOTED IN THE itemStateChange() OR OTHERS TOO,
    WE CAN ONLY MANIPULATE THE EXISTING ONES.
    FOR EG:- WE CANNOT DO jl = new JLabel(~~);
*/