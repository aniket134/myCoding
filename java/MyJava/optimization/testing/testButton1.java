
/*<applet code=testButton1 width=600 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class testButton1 extends JApplet implements ActionListener{
	JTextField jtf;
	String jtfData = null;

	public void init(){
		
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());



		JButton jb1 = new JButton("Button 1");
		jb1.setActionCommand("button1");
		jb1.addActionListener(this);
		cp.add(jb1);
	
		JButton jb2 = new JButton("Button 2");
		jb2.setActionCommand("button2");
		jb2.addActionListener(this);
		cp.add(jb2);

		JButton jb3 = new JButton("Button 3");
		jb3.setActionCommand("button3");
		jb3.addActionListener(this);
		cp.add(jb3);
		
		jtf = new JTextField(jtfData);
		cp.add(jtf);
		
		

	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(20,20,40,50);
}
	public void actionPerformed(ActionEvent ae){
		jtf.setText(ae.getActionCommand());
	}	
}